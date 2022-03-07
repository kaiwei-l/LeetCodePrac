class Solution:
    def kClosest(self, points: List[List[int]], k: int) -> List[List[int]]:
        newList = []
        for point in points:
            copy = [point[0], point[1], math.sqrt(point[0]**2 + point[1]**2)]
            newList.append(copy)
        newList = sorted(newList, key= lambda x : x[2])
        ans = []
        for i in range(k):
            point = newList[i]
            ans.append([point[0], point[1]])
        return ans