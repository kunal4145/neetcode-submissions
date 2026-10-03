/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }

        boolean curr = (root == p) || (root == q);
        if (curr) {
            return root;
        } 
        boolean left = hasNode(root.left, p, q);
        boolean right = hasNode(root.right, p, q);

        if (left && right) {
            return root;
        } else if (left) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (right) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return null;
        }
    }

    private boolean hasNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }

        if (root == p || root == q) {
            return true;
        } else {
            return hasNode(root.left, p, q) || hasNode(root.right, p, q);
        }
    }
}
