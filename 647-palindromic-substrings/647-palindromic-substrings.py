class Solution:
    def countSubstrings(self, s: str) -> int:
        def countHelper(s, left, right):
            currCount = 0
            while left >= 0 and right < len(s) and s[left] == s[right]:
                left -= 1
                right += 1
                currCount += 1
            return currCount
        count = 0
        for left in range(len(s)):
            count += countHelper(s, left, left)
            count += countHelper(s, left, left + 1)
        return count
        