class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        for (int[] i : intervals) {
            if (minHeap.isEmpty()) {
                minHeap.add(i);
            } else {
                if (minHeap.peek()[1] <= i[0]) {
                    minHeap.poll();
                    minHeap.add(i);
                } else {
                    minHeap.add(i);
                }
            }
        }
        return minHeap.size();
    }
}