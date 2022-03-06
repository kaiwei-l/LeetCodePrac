class Solution:
    def minMeetingRooms(self, intervals: List[List[int]]) -> int:
        intervals = sorted(intervals, key = lambda x: x[0])
        heapRooms = []
        heapq.heappush(heapRooms, intervals[0][1])
        for i in range(1, len(intervals)):
            interval = intervals[i]
            if heapRooms[0] <= interval[0]:
                heapq.heappop(heapRooms)
            heapq.heappush(heapRooms, interval[1])
        return len(heapRooms)