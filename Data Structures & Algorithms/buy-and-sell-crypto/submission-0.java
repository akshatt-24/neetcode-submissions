class Solution {
    public int maxProfit(int[] prices) {
       int maxProfit = 0;
        Stack<Integer> stack = new Stack();

       for(int i = 0; i <  prices.length ; i++) {
            int profit = 0;
            if(!stack.isEmpty()) {
                if(stack.peek() < prices[i]) {
                    profit = prices[i] - stack.peek();
                    maxProfit = Math.max(maxProfit, profit);
                }
                else {
                    stack.push(prices[i]);
                }
            }
            else {
                stack.push(prices[i]);
            }
       }
       return maxProfit;
    }
}
