# https://leetcode.com/problems/power-of-three/submissions/

class Solution:
    def isPowerOfThree(self, n: int) -> bool:
        p = 0
        temp = 3**p
        while temp < n:
            temp = temp*3
        return temp == n