class Solution {
    public int minPathSum(int[][] grid) {
        int rowLimit = grid.length;
        int colLimit = grid[0].length;
        int[][] dp = new int[rowLimit][colLimit];
        dp[rowLimit - 1][colLimit - 1] = grid[rowLimit - 1][colLimit - 1];
        for (int row = rowLimit - 1; row > -1; row--) {
            for (int col = colLimit - 1; col > -1; col--) {
                if (row == rowLimit - 1 && col != colLimit - 1) {
                    dp[row][col] = grid[row][col] + dp[row][col + 1];
                } else if (row != rowLimit - 1 && col == colLimit - 1) {
                    dp[row][col] = grid[row][col] + dp[row + 1][col];
                } else if (row != rowLimit - 1 && col != colLimit - 1) {
                    dp[row][col] = grid[row][col] + Math.min(dp[row + 1][col], dp[row][col + 1]);
                }
            }
        }
        return dp[0][0];
    }
}