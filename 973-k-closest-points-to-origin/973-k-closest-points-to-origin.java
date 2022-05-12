class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            int x1 = a[0];
            int y1 = a[1];
            int x2 = b[0];
            int y2 = b[1];
            return (x2 * x2 + y2 * y2) - (x1 * x1 + y1 * y1);
        });
        
        for (int i = 0; i < points.length; i++) {
            q.add(points[i]);
            if (q.size() > k) {
                q.poll();
            }
        }
        
        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            ans[i] = q.poll();
        }
        return ans;
    }
}