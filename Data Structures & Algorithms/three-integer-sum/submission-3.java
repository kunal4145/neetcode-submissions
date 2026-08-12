class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i=0; i<nums.length; i++) {
            while (i>0 && i<nums.length && nums[i] == nums[i-1]) {
                i++;
            }

            int j=i+1, k=nums.length-1;

            while (j < k) {
                 if (nums[j] + nums[k] + nums[i] < 0) {
                    j++;
                } else if (nums[j] + nums[k] + nums[i] > 0) {
                    k--;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j++]);
                    list.add(nums[k--]);
                    result.add(list);
                    while (j < nums.length && nums[j] == nums[j-1]) {
                        j++;
                    }
                }
            }
        }

        return result;
    }
}
