class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[] memo = new int[n];
        memo[0] = grid[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j != 0) {
                    memo[j] = memo[j - 1] + grid[i][j];
                } else if (j == 0 && i != 0) {
                    memo[j] = memo[j] + grid[i][j];
                } else if (i != 0 && j != 0) {
                    memo[j] = Math.min(memo[j], memo[j - 1]) + grid[i][j];
                }
            }
        }
        return memo[n - 1];
    }
}