class Solution:
    def search(self, nums: List[int], target: int) -> int:
        if len(nums) == 1 and target == nums[0]:
            return 0
        
        left = 0
        right = len(nums) - 1
        while left <= right:
            mid = left + (right - left) // 2
            if target == nums[mid]:
                return mid
            elif nums[mid] >= nums[left]:
                if nums[left] <= target < nums[mid]:
                    right = mid - 1
                else:
                    left = mid + 1
            elif nums[mid] < nums[left]:
                if nums[right] >= target > nums[mid]:
                    left = mid + 1
                else:
                    right = mid - 1
        return -1