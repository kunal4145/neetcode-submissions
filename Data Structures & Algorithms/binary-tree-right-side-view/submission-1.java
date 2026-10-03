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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> result = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);

        while (!q.isEmpty()) {
            int level = q.size();
            result.add(q.getFirst().val);

            for (int i=0; i<level; i++) {
                TreeNode node = q.removeFirst();
                if (node.right != null) {
                    q.addLast(node.right);
                }
                if (node.left != null) {
                    q.addLast(node.left);
                }
            }
        }

        return result;
    }
}
