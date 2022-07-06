class Solution {
    public int[] amountPainted(int[][] paint) {
        int n = paint.length;
        int[] log = new int[n];
        int[] lines = new int[50001];
        for (int i = 0; i < n; i++) {
            int area = 0;
            int start = paint[i][0];
            int end = paint[i][1];
            while (start < end) {
                if (lines[start] != 0) {
                    start = lines[start];
                } else {
                    lines[start] = end;
                    area++;
                    start++;
                }
            }
            log[i] = area;
        }
        return log;
    }
}