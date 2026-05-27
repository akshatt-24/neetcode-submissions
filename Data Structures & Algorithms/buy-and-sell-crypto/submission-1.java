class Solution {
    public int maxProfit(int[] prices) {
       int minBuy = prices[0];
       int maxP = 0;

       for(int i = 1; i < prices.length; i++) {
        maxP = Math.max(prices[i] - minBuy, maxP);
        minBuy = Math.min(prices[i], minBuy);
       }
       return maxP;
    }
}
