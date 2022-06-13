class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buyPrice = prices[0];
        for (int p : prices) {
            if (p > buyPrice) {
                maxProfit = Math.max(maxProfit, p - buyPrice);
            } else {
                buyPrice = p;
            }
        }
        return maxProfit;
    }
}