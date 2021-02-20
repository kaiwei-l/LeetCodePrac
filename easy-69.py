# https://leetcode.com/problems/sqrtx/

class Solution:
    def mySqrt(self, x: int) -> int:
        # My solution
        # if x == 0 or x == 1:
        #     return x
        # for i in range(1, x//2 + 1):
        #     if i*i == x:
        #         return i
        #     elif i*i > x:
        #         return i - 1
        # return i
        
        l = 0
        r = x
        while l <= r:
            mid = l + (r - l)//2
            if mid**2 <= x < (mid + 1)**2:
                return mid
            elif x < mid**2:
                r = mid - 1
            else:
                l = mid + 1