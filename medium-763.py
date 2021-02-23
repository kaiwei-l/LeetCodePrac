# https://leetcode.com/problems/partition-labels/

class Solution:
    def partitionLabels(self, S: str) -> List[int]:
        if len(S) == 0:
            return [0]
        last = dict()
        for i in range(len(S)):
            last[S[i]] = i
        ans = []
        left = 0
        right = 0
        for i in range(len(S)):
            right = max(right, last[S[i]])
            if i == right:
                ans.append(right - left + 1)
                left = i + 1
        return ans
                
        