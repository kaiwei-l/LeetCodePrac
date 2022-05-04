class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 1) return 1;
        
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        int ans = 1;
        for (int i = 1; i < points.length; i++) {
            int start = points[i][0];
            int end = points[i][1];
            int prevStart = points[i - 1][0];
            int prevEnd = points[i - 1][1];
            if (start <= prevEnd) {
                start = Math.max(prevStart, start);
                end = Math.min(prevEnd, end);
            } else {
                ans++;
            }
            points[i][0] = start;
            points[i][1] = end;
        }
        return ans;
    }
}