class Solution:
    def minWindow(self, s: str, t: str) -> str:
        if len(t) > len(s):
            return ""
        left = 0
        right = 0
        optimalLeft = 0
        optimalRight = 0
        minLen = float("inf")
        counterT = dict()
        for c in t:
            if c in counterT.keys():
                counterT[c] += 1
            else:
                counterT[c] = 1
        requested = len(counterT)
        formed  = 0
        windowsCount = dict()
        while right < len(s):
            currChar = s[right]
            if currChar in windowsCount.keys():
                windowsCount[currChar] += 1
            else:
                windowsCount[currChar] = 1
            if currChar in counterT.keys() and windowsCount[currChar] == counterT[currChar]:
                formed += 1
            while left <= right and formed == requested:
                c = s[left]
                if right - left + 1 < minLen:
                    minLen = right - left + 1
                    optimalLeft = left
                    optimalRight = right
                windowsCount[c] -= 1
                if c in counterT.keys() and windowsCount[c] < counterT[c]:
                    formed -= 1
                left += 1
            right += 1
        if minLen == float("inf"):
            return ""
        else:
            return s[optimalLeft : optimalRight + 1]
        
            