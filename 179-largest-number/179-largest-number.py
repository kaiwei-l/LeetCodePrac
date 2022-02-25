class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        def compare(num1, num2):
            concat1 = num1 + num2
            concat2 = num2 + num1
            if concat2 > concat1:
                return 1
            elif concat2 == concat1:
                return 0
            else:
                return -1
        
        for i in range(len(nums)):
            nums[i] = str(nums[i])
        nums = sorted(nums, key=functools.cmp_to_key(compare))
        if nums[0] == "0":
            return "0"
        else:
            ans = ""
            for num in nums:
                ans += num
            return ans