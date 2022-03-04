class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = s.lower()
        newStr = ""
        for c in s:
            if c.isalnum():
                newStr = newStr + c
        left = 0
        right = len(newStr) - 1
        while left <= right:
            if newStr[left] == newStr[right]:
                left += 1
                right -= 1
            else:
                return False
        return True
        