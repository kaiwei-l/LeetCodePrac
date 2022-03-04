class Solution:
    def longestPalindrome(self, s: str) -> str:
        def helper(s, left, right):
            while left >= 0 and right < len(s) and s[left] == s[right]:
                left -= 1
                right += 1
            return s[left + 1 : right]
        res = ""
        for i in range(len(s)):
            tmp = helper(s, i, i)
            if len(tmp) > len(res):
                res = tmp
            tmp = helper(s, i, i + 1)
            if len(tmp) > len(res):
                res = tmp
        return res