class Solution {
    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        memo[0][0] = 1;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (row == 0 && col != 0) {
                    memo[row][col] = memo[row][col - 1];
                } else if (col == 0 && row != 0) {
                    memo[row][col] = memo[row - 1][col];
                } else if (row == 0 && col == 0) {
                    memo[row][col] = 1;
                } else {
                    memo[row][col] = memo[row - 1][col] + memo[row][col - 1];
                }
            }
        }
        return memo[m - 1][n - 1];
    }
}