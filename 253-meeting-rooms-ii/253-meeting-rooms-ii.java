class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a, b));
        
        for (int[] i : intervals) {
            if (minHeap.isEmpty()) {
                minHeap.add(i[1]);
            } else {
                if (minHeap.peek() > i[0]) {
                    minHeap.add(i[1]);
                } else {
                    minHeap.poll();
                    minHeap.add(i[1]);
                }
            }
        }
        return minHeap.size();
    }
}