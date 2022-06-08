class Solution {
    int m;
    int n;
    
    public int minPathSum(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[j] = grid[0][0];
                } else if (i == 0 && j != 0) {
                    dp[j] = dp[j - 1] + grid[i][j];
                } else if (j == 0 && i != 0) {
                    dp[j] += grid[i][j]; 
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]);
                    dp[j] += grid[i][j];
                }
            }
        }
        return dp[n - 1];
    }
}