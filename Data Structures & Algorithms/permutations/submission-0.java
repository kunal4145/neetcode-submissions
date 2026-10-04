class Solution {
    private List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        permuteUtil(nums, visited, new ArrayList<>());

        return result;
    }

    private void permuteUtil(int[] nums, boolean[] visited, List<Integer> curr) {
        if (curr.size() == nums.length) {
            List<Integer> res = new ArrayList<>(curr);
            result.add(res);
            return;
        }

        for (int i=0; i<nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                curr.add(nums[i]);
                permuteUtil(nums, visited, curr);
                curr.remove(curr.size()-1);
                visited[i] = false;
            }
        }
    }
}
