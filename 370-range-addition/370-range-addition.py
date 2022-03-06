class Solution:
    def getModifiedArray(self, length: int, updates: List[List[int]]) -> List[int]:
        res = [0] * length
        for update in updates:
            value = update[2]
            start = update[0]
            end = update[1]
            res[start] += value
            
            if end + 1 < length:
                res[end + 1] -= value
        arrSum = 0
        for i in range(len(res)):
            arrSum += res[i]
            res[i] = arrSum
        return res