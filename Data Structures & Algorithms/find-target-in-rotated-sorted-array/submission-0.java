class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);
        int n = nums.length;
        int l = pivot, r = (pivot + nums.length - 1);
        int mid;
        
        while (l <= r) {
            mid = l + (r - l) / 2;

            if (nums[mid % n] > target) {
                r = mid - 1;
            } else if (nums[mid % n] < target){
                l = mid + 1;
            } else {
                return mid % n;
            }
        }

        return -1;
    }

    private int findPivot(int[] nums) {
        int l = 0, r = nums.length - 1;
        int mid;

        while (l < r) {
            mid = l + (r - l) / 2;

            if (nums[mid] < nums[r]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }
}
