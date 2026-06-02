class Solution {

    public int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;

        int maxProfit = 0;

        for(int i = 0; i < prices.length; i++) {

            // Update minimum buying price
            minPrice = Math.min(minPrice, prices[i]);

            // Calculate current profit
            int profit = prices[i] - minPrice;

            // Update maximum profit
            maxProfit = Math.max(maxProfit, profit);
        }

        return maxProfit;
    }
}