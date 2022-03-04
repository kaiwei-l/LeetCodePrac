class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        def twoSum(ans, curr, nums, left):
            counter = dict()
            i = left
            while i < len(nums):
                complement = -curr - nums[i]
                if complement in counter.keys():
                    ans.append([curr, nums[i], complement])
                    while i + 1 < len(nums) and nums[i + 1] == nums[i]:
                        i += 1
                counter[nums[i]] = complement
                i += 1
                    
        if len(nums) < 3:
            return []
        ans = []
        nums.sort()
        for i in range(len(nums) - 2):
            if nums[i] > 0:
                break
            if i == 0 or nums[i - 1] != nums[i]:
                curr = nums[i]
                left = i + 1
                twoSum(ans, curr, nums, left)
        return ans
        