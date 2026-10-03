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
    public int goodNodes(TreeNode root) {
        return goodNodesUtil(root, root.val);
    }

    private int goodNodesUtil(TreeNode root, int maxsofar) {
        if (root == null) {
            return 0;
        }

        int res = (root.val >= maxsofar) ? 1 : 0;
        maxsofar = Math.max(maxsofar, root.val);
        res += goodNodesUtil(root.left, maxsofar);
        res += goodNodesUtil(root.right, maxsofar);

        return res;
    }
}
