class Solution {
    int m;
    int n;
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int ans = 0;
    
    public int getMaximumGold(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    backtrack(i, j, grid, 0);
                }
            }
        }
        return ans;
    }
    
    public void backtrack(int row, int col, int[][] grid, int res) {
        int gold = grid[row][col];
        grid[row][col] = 0;
        res += gold;
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] != 0) {
                backtrack(newRow, newCol, grid, res);
            }
        }
        ans = Math.max(ans, res);
        grid[row][col] = gold;
    }
}