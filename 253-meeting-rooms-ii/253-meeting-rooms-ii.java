class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int m = intervals.length;
        int n = 2;
        if (m == 1) return 1;
        Integer[][] intervalsCopy = new Integer[m][2];
        for (int i = 0; i < m; i++) {
            intervalsCopy[i][0] = intervals[i][0];
            intervalsCopy[i][1] = intervals[i][1];
        }
        Arrays.sort(intervalsCopy, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<Integer> allocator = new PriorityQueue<>((a, b) -> a - b);
        allocator.add(intervalsCopy[0][1]);
        for (int i = 1; i < m; i++) {
            if (intervalsCopy[i][0] >= allocator.peek()) {
                allocator.poll();
                allocator.add(intervalsCopy[i][1]);
            } else {
                allocator.add(intervalsCopy[i][1]);
            }
        }
        return allocator.size();
    }
}