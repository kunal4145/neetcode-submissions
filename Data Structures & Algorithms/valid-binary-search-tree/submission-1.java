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
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);

        if (inorder.size() < 2) {
            return true;
        }

        for (int i=1; i<inorder.size(); i++) {
            if (inorder.get(i) <= inorder.get(i-1)) {
                return false;
            }
        }

        return true;
    }

    private void inorderTraversal(TreeNode root, List<Integer> inorder) {
        if (root != null) {
            inorderTraversal(root.left, inorder);
            inorder.add(root.val);
            inorderTraversal(root.right, inorder);
        }
    }
}
