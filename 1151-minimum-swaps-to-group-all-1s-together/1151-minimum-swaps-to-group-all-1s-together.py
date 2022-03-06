class Solution:
    def minSwaps(self, data: List[int]) -> int:
        ones = 0
        for num in data:
            ones += num
        if ones <= 1:
            return 0
        minSwap = float('inf')
        left = 0
        right = left + ones - 1
        currZeroCount = 0
        for i in range(left, right + 1):
            if data[i] == 0:
                currZeroCount += 1
        minSwap = min(minSwap, currZeroCount)
        while right < len(data):
            oldHead = data[left]
            left += 1
            right += 1
            if right < len(data):
                newTail = data[right]
                if oldHead == 0:
                    currZeroCount -= 1
                if newTail == 0:
                    currZeroCount += 1
                minSwap = min(minSwap, currZeroCount)
        return minSwap