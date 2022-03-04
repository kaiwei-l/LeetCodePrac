class Solution:
    def characterReplacement(self, s: str, k: int) -> int:
        left = 0
        counter = [0]*26
        maxLen = 0
        maxCount = 0
        for right in range(0, len(s)):
            counter[ord(s[right]) - 65] += 1
            maxCount = max(maxCount, counter[ord(s[right]) - 65])
            while right - left + 1 - maxCount > k:
                counter[ord(s[left]) - 65] -= 1
                left += 1
            maxLen = max(maxLen, right - left + 1)
        return maxLen