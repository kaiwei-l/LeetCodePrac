# https://leetcode.com/problems/remove-duplicates-from-sorted-array/submissions/

def removeDuplicates(self, nums: List[int]) -> int:
        # My Solution
        # if len(nums) == 1:
        #     return 1
        # if len(nums) == 2 and nums[0] == nums[1]:
        #     return 1
        # if len(nums) == 2 and nums[0] != nums[1]:
        #     return 2
        # swapPointer = 0
        # for i in range(1, len(nums) - 1):
        #     if nums[i] != nums[i - 1] and nums[i] == nums[i + 1]:
        #         swapPointer += 1
        #         nums[swapPointer] = nums[i]
        #     elif nums[i] != nums[i - 1] and nums[i] != nums[i + 1]:
        #         swapPointer += 1
        #         nums[swapPointer] = nums[i]
        #     elif nums[i] == nums[i - 1] and nums[i] != nums[i + 1]:
        #         swapPointer += 1
        #         nums[swapPointer] = nums[i + 1]
        # if nums[len(nums) - 1] != nums[len(nums) - 2]:
        #     swapPointer += 1
        #     nums[swapPointer] = nums[len(nums) - 1]
        # return swapPointer + 1
        
        if len(nums) == 0:
            return 0
        i = 0
        for j in range(1, len(nums)):
            if nums[i] != nums[j]:
                i += 1
                nums[i] = nums[j]
        return i + 1