# https://leetcode.com/problems/factorial-trailing-zeroes/

class Solution:
    def trailingZeroes(self, n: int) -> int:
        # My solution
        # res = 1
        # while n != 0:
        #     res *= n
        #     n -= 1
        # count = 0
        # while res != 0:
        #     if res % 10 == 0:
        #         count += 1
        #         res = res // 10
        #     else:
        #         break
        # return count
        
        count = 0
        while n > 0:
            count += n // 5
            n = n // 5
        return count
 