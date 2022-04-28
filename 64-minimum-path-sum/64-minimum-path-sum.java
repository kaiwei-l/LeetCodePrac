class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        dp[0][0] = grid[0][0];
        visited[0][0] = true;
        // for (int i = 1; i < m; i++) {
        //     dp[i][0] = grid[i][0] + dp[i - 1][0];
        //     visited[i][0] = true;
        // }
        // for (int j = 1; j < n; j++) {
        //     dp[0][j] = grid[0][j] + dp[0][j - 1];
        //     visited[0][j] = true;
        // }
        return backtrack(dp, visited, grid, m - 1, n - 1);
    }
    
    private int backtrack(int[][] dp, boolean[][] visited, int[][] grid, int row, int col) {
        if (visited[row][col]) {
            return dp[row][col];
        } else {
            int newRow = row - 1;
            int newCol = col - 1;
            visited[row][col] = true;
            if (newRow >= 0 && newCol >= 0) {
                dp[row][col] = Math.min(backtrack(dp, visited, grid, row, newCol), backtrack(dp, visited, grid, newRow, col)) + grid[row][col];   
            } else if (newRow < 0) {
                dp[row][col] = backtrack(dp, visited, grid, row, newCol) + grid[row][col];
            } else {
                dp[row][col] = backtrack(dp, visited, grid, newRow, col) + grid[row][col];
            }
            return dp[row][col];
        }
    }
}