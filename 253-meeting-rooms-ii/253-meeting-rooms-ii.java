class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> a - b);
        for (int[] meet : intervals) {
            int startTime = meet[0];
            int endTime = meet[1];
            if (q.size() == 0) {
                q.add(endTime);
            } else {
                int currEndTime = q.peek();
                if (currEndTime > startTime) {
                    q.add(endTime);
                } else {
                    q.poll();
                    q.add(endTime);
                }
            }
        }
        return q.size();
    }
}