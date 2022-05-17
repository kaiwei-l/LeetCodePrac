class Solution {
    public int uniquePaths(int m, int n) {
        int[] memo = new int[n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (row == 0 && col != 0) {
                    memo[col] = memo[col - 1];
                } else if (col == 0 && row != 0) {
                    memo[col] = memo[col];
                } else if (row == 0 && col == 0) {
                    memo[col] = 1;
                } else {
                    memo[col] += memo[col - 1];
                }
            }
        }
        return memo[n - 1];
    }
}