class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if len(s) == 1:
            return 1
        counter = dict()
        maxLen = 0
        left = 0
        right = 0
        currLen = 0
        while right < len(s):
            currChar = s[right]
            if currChar in counter.keys():
                counter[currChar] += 1
                currLen += 1
                while counter[currChar] > 1:
                    counter[s[left]] -= 1
                    left += 1
                    currLen -= 1
            else:
                counter[currChar] = 1
                currLen += 1
            right += 1
            maxLen = max(maxLen, currLen)
        return maxLen
                    