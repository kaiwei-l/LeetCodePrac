class Solution {
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int m;
    int n;
    
    public int getMaximumGold(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int gold = backtrack(grid, i, j);
                ans = Math.max(ans, gold);
            }
        }
        return ans;
    }
    
    public int backtrack(int[][] grid, int row, int col) {
        int gold = grid[row][col];
        int goldFromNext = 0;
        grid[row][col] = 0;
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] != 0) {
                goldFromNext = Math.max(goldFromNext, backtrack(grid, newRow, newCol));
            }
        }
        grid[row][col] = gold;
        return gold + goldFromNext;
    }
}