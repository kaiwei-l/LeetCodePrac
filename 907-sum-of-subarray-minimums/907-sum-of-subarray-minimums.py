class Solution:
    def sumSubarrayMins(self, arr: List[int]) -> int:
        previousLess = []
        nextLess = []
        leftDistance = [-1] * len(arr)
        rightDistance = [-1] * len(arr)
        for i in range(len(arr)):
            while len(previousLess) != 0 and arr[previousLess[-1]] >= arr[i]:
                previousLess.pop()
            if len(previousLess) == 0:
                leftDistance[i] = i + 1
            else:
                leftDistance[i] = i - previousLess[-1]
            previousLess.append(i)
        
        for i in range(len(arr) - 1, -1, -1):
            while len(nextLess) != 0 and arr[nextLess[-1]] > arr[i]:
                nextLess.pop()
            if len(nextLess) == 0:
                rightDistance[i] = len(arr) - i
            else:
                rightDistance[i] = nextLess[-1] - i
            nextLess.append(i)
        ans = 0
        for i in range(len(arr)):
            ans += arr[i] * leftDistance[i] * rightDistance[i]
        return ans % (10**9 + 7)