class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);
        int result = 0;

        for (int num : nums) {
            if (map.containsKey(num-1)) {
                map.put(num, map.get(num-1) + 1);
            } else {
                map.put(num, 1);
            }
        }

        for (int val : map.values()) {
            result = Math.max(result, val);
        }

        return result;
    }
}
