class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        if len(nums) == 0:
            return 0
        
        maxSoFar = nums[0]
        minSoFar = nums[0]
        result = maxSoFar
        for i in range(1, len(nums)):
            curr = nums[i]
            tempMax = max(maxSoFar * curr, minSoFar * curr, curr)
            minSoFar = min(maxSoFar * curr, minSoFar * curr, curr)
            maxSoFar = tempMax
            result = max(result, maxSoFar)
        return result