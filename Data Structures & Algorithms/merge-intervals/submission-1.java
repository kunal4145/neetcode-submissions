class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();

        int i=1;
        result.add(intervals[0]);
        while (i < intervals.length) {
            int[] lastInterval = result.get(result.size()-1);
            if (intervals[i][0] > lastInterval[1]) {
                result.add(intervals[i]);
                i++;
            } else {
                lastInterval[0] = Math.min(lastInterval[0], intervals[i][0]);
                lastInterval[1] = Math.max(lastInterval[1], intervals[i][1]);
                i++;
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
