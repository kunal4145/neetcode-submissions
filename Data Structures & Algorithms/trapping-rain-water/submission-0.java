class Solution {
    public int trap(int[] height) {
        int n = height.length;

        if (n <= 2) {
            return 0;
        }

        int[] prefix = new int[n];
        int[] suffix = new int[n];

        prefix[0] = height[0];
        for (int i=1; i<n; i++) {
            prefix[i] = Math.max(prefix[i-1], height[i]);
        }

        suffix[n-1] = height[n-1];
        for (int j=n-2; j>=0; j--) {
            suffix[j] = Math.max(suffix[j+1], height[j]);
        }

        int water = 0;
        for (int i=0; i<n; i++) {
            water += Math.min(prefix[i], suffix[i]) - height[i];
        }

        return water;
    }
}
