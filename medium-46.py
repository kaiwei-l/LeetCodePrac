# https://leetcode.com/problems/permutations/

class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        def permuteBacktrack(lst, currentList, res):
            if len(currentList) == len(lst):
                res.append(currentList[:]) # [:] is a deep copy since otherwise we'd be append the same list over and over
            else:
                for num in lst:
                    if num not in currentList:
                        currentList.append(num)
                        permuteBacktrack(lst, currentList, res)
                        currentList.pop()
            
        res = []
        permuteBacktrack(nums, [], res)
        return res
        