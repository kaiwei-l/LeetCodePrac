class Solution:
    def subArrayRanges(self, nums: List[int]) -> int:
        # dp = []
        # ans = 0
        # for i in range(len(nums)):
        #     row = [[0, None, None]] * len(nums)
        #     dp.append(row)
        # for i in range(len(nums)):
        #     dp[i][i] = (0, nums[i], nums[i])
        # for i in range(len(nums) - 1):
        #     for j in range(i + 1, len(nums)):
        #         currNum = nums[j]
        #         if dp[i][j-1][1] <= currNum <= dp[i][j-1][2]:
        #             dp[i][j][0] = dp[i][j-1][0]
        #             dp[i][j][1] = dp[i][j-1][1]
        #             dp[i][j][2] = dp[i][j-1][2]
        #             ans += dp[i][j][0]
        #         elif currNum > dp[i][j-1][2]:
        #             dp[i][j][0] = currNum - dp[i][j-1][1]
        #             dp[i][j][1] = dp[i][j-1][1]
        #             dp[i][j][2] = currNum
        #             ans += dp[i][j][0]
        #         else:
        #             dp[i][j][0] = dp[i][j-1][2] - currNum
        #             dp[i][j][1] = currNum
        #             dp[i][j][2] = dp[i][j-1][2]
        #             ans += dp[i][j][0]
        # return ans
        res = 0
        n = len(nums)
        for i in range(n):
            l,r = nums[i],nums[i]
            for j in range(i, n):
                l = min(l, nums[j])
                r = max(r, nums[j])
                res += r - l
        return res