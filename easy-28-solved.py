# https://leetcode.com/problems/implement-strstr/

class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        if len(needle) == 0:
            return 0
        if len(needle) > len(haystack):
            return -1
        i = 0
        while i <= len(haystack) - len(needle):
            if haystack[i] == needle[0]:
                findNeedle = True
                for j in range(len(needle)):
                    if needle[j] != haystack[i + j]:
                        findNeedle = False
                        break
                if findNeedle:
                    return i
            i += 1
        return -1