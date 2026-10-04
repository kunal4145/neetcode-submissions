class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];

        subsetsUtil(nums, visited, 0);

        return result;
    }

    public void subsetsUtil(int[] nums, boolean[] visited, int curr) {
        if (curr == nums.length) {
            List<Integer> list = new ArrayList<>();

            for (int i=0; i<nums.length; i++) {
                if (visited[i]) {
                    list.add(nums[i]);
                }
            }

            result.add(list);
            return;
        }

        subsetsUtil(nums, visited, curr+1);
        visited[curr] = true;
        subsetsUtil(nums, visited, curr+1);
        visited[curr] = false;
    }
}
