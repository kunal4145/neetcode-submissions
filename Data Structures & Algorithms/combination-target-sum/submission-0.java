class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<>();

        combinationSumUtil(nums, target, new ArrayList<>(), 0);

        return result; 
    }

    private void combinationSumUtil(int[] nums, int target, List<Integer> curr, int i) {
        if (target < 0 || i >= nums.length) {
            return;
        } else if (target == 0) {
            List<Integer> res = new ArrayList<>(curr);
            result.add(res);
            return;
        }

        
        curr.add(nums[i]);
        combinationSumUtil(nums, target-nums[i], curr, i);
        curr.remove(curr.size()-1);
        combinationSumUtil(nums, target, curr, i+1);
    }
}
