class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int result = 0;
        int[] lastInterval = intervals[0];

        for (int i=1; i<intervals.length; i++) {
            if (intervals[i][0] >= lastInterval[1]) {
                lastInterval = intervals[i];
            } else {
                result++;
                lastInterval[0] = Math.min(lastInterval[0], intervals[i][0]);
                lastInterval[1] = Math.min(lastInterval[1], intervals[i][1]);
            }
        }

        return result;
    }
}
