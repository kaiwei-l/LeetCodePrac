# https://leetcode.com/problems/reverse-bits/

class Solution:
    def reverseBits(self, n: int) -> int:
        ans = 0
        power = 31
        while n:
            ans += (n & 1) << power
            n = n >> 1
            power -= 1
        return ans