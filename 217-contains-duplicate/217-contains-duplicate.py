class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        counter = dict()
        for num in nums:
            if num in counter.keys():
                return True
            else:
                counter[num] = num
        return False