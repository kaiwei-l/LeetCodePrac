class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> {
            if (a[0] < b[0]) return -1;
            return 1;
        });
        int minMoves = 1;
        for (int i = 1; i < points.length; i++) {
            int[] currPoint = points[i];
            int[] prevPoint = points[i - 1];
            if (currPoint[0] > prevPoint[1]) {
                minMoves++;
            } else if (currPoint[1] >= prevPoint[1]) {
                currPoint[1] = prevPoint[1];
                points[i] = currPoint;
            }
        }
        return minMoves;
    }
}