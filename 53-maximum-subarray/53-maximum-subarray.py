class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        currentArr = nums[0]
        maxArr = nums[0]
        for i in range(1, len(nums)):
            currentArr = max(nums[i], nums[i] + currentArr)
            maxArr = max(currentArr, maxArr)
        return maxArr