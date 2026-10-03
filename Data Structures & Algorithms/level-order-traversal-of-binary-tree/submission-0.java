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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);

        while (!q.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int levelsize = q.size();

            for (int i=0; i<levelsize; i++) {
                TreeNode node = q.removeFirst();
                level.add(node.val);
                if (node.left != null) {
                    q.addLast(node.left);
                }
                if (node.right != null) {
                    q.addLast(node.right);
                }
            }
            result.add(level);
        }

        return result;
    }
}
