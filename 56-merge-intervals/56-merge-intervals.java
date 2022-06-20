class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) return new int[0][2];
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        ArrayDeque<int[]> s = new ArrayDeque<>();
        for (int[] i : intervals) {
            if (s.isEmpty() || s.getLast()[1] < i[0]) {
                s.addLast(i);
            } else {
                while (!s.isEmpty() && s.getLast()[1] >= i[0]) {
                    int[] prev = s.removeLast();
                    int newStart = Math.min(prev[0], i[0]);
                    int newEnd = Math.max(prev[1], i[1]);
                    i[0] = newStart;
                    i[1] = newEnd;
                }
                s.addLast(i);
            }
        }
        int[][] ans = new int[s.size()][2];
        for(int i = 0; i < ans.length; i++) {
            ans[i] = s.removeFirst();
        }
        return ans;
    }
}