# https://leetcode.com/problems/counting-bits/

class Solution:
    def countBits(self, num: int) -> List[int]:
        # My solution
        # ans = []
        # for i in range(num + 1):
        #     binary = bin(i)[2:]
        #     ones = binary.count('1')
        #     ans.append(ones)
        # return ans
        
        dp = [0] * (num + 1)
        for n in range(num + 1):
            dp[n] = dp[n // 2] + (n % 2)
        return dp
            