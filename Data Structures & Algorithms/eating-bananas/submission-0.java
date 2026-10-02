class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for (int x : piles) {
            max = Math.max(x, max);
        }

        int l=0, r=max;
        int result = r;

        while (l <= r) {
            int mid = l + (r-l) / 2;

            int time = 0;
            for (int p : piles) {
                time += Math.ceil((double) p / mid);
            }

            if (time <= h) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return result;
    }
}
