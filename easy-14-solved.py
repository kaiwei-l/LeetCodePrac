class Solution:
    def longestCommonPrefix(self, strs: List[str]) -> str:
        if len(strs) == 0:
            return ""
        lcp = strs[0]
        for s in strs:
            if len(s) < len(lcp):
                lcp = lcp[:len(s)]
            else:
                s = s[:len(lcp)]
            for i in range(len(s)):
                if s[i] != lcp[i]:
                    lcp = lcp[:i]
                    break
            if len(lcp) == 0:
                return ""
        return lcp