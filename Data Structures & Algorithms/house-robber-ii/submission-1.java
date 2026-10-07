class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        
        int[] result1 = new int[n];
        int[] result2 = new int[n];
        int result;

        result1[1] = nums[1];
        result1[2] = Math.max(nums[1], nums[2]);
        result = result1[2];

        for (int i=3; i<n; i++) {
            result1[i] = Math.max(result1[i-2]+nums[i], result1[i-1]);
            result = Math.max(result, result1[i]);
        }

        result2[0] = nums[0];
        result2[1] = Math.max(nums[0], nums[1]);
        result = Math.max(result, result2[1]);

        for (int i=2; i<n-1; i++) {
            result2[i] = Math.max(result2[i-2]+nums[i], result2[i-1]);
            result = Math.max(result, result2[i]);
        }

        return result;
    }
}
