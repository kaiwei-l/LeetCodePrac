# https://leetcode.com/problems/valid-palindrome/

class Solution:
    def isPalindrome(self, s: str) -> bool:
        if len(s) == 0:
            return True
        start = 0
        end = len(s) - 1
        while start < end:
            if s[start].isalnum() and s[end].isalnum():
                if s[start].lower() != s[end].lower():
                    return False
                else:
                    start += 1
                    end -= 1
            elif s[start].isalnum():
                end -= 1
            elif s[end].isalnum():
                start += 1
            else:
                start += 1
                end -= 1
        return True
            