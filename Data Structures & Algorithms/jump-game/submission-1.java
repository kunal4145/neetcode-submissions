class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int reachable = n-1;

        for (int i=n-2; i>=0; i--) {
            if (i + nums[i] >= reachable) {
                reachable = i;
            }
        }

        return reachable == 0;
    }
}
