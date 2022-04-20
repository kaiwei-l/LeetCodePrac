class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int p : prices) {
            if (p < minPrice) {
                minPrice = p;
            } else if (p - minPrice > maxProfit) {
                maxProfit = p - minPrice;
            }
        }
        return maxProfit;
    }
}