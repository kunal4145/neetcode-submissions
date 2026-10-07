class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int top = cost.length;
        int[] result = new int[top+1];
        result[top-2] = cost[top-2];
        result[top-1] = cost[top-1];

        for (int i=top-3; i>=0; i--) {
            result[i] = cost[i] + Math.min(result[i+1], result[i+2]);
        }

        return Math.min(result[0], result[1]);
    }
}
