class Solution {
    public int maxProfit(int[] prices) {
        int minSoFar = prices[0];
        int maxProfit = 0;

        for (int i=1; i<prices.length; i++) {
            maxProfit = Math.max(prices[i]-minSoFar, maxProfit);
            minSoFar = Math.min(prices[i], minSoFar);
        }

        return maxProfit;
    }
}
