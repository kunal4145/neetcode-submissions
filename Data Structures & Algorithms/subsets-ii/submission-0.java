class Solution {
    private List<List<Integer>> result;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<>();

        Arrays.sort(nums);
        subsetsUtil(nums, new ArrayList<>(), 0);

        return result;
    }

    private void subsetsUtil(int[] nums, List<Integer> curr, int i) {
        if (i == nums.length) {
            List<Integer> res = new ArrayList<>(curr);
            result.add(res);
            return;
        }

        curr.add(nums[i]);
        subsetsUtil(nums, curr, i+1);

        while (i+1<nums.length && nums[i] == nums[i+1]) {
            i++;
        }
        curr.remove(curr.size()-1);
        subsetsUtil(nums, curr, i+1);
    }
}
