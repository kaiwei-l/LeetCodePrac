class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        minP = prices[0]
        maxProfit = 0
        for p in prices:
            if p < minP:
                minP = p
            currentProfit = p - minP
            maxProfit = max(maxProfit, currentProfit)
        return maxProfit
       