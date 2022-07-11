class Solution {
    int m;
    int n;
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int max;
    int[][] cache;
    public int longestIncreasingPath(int[][] matrix) {
        m = matrix.length;
        n = matrix[0].length;
        max = 0;
        cache = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                max = Math.max(max, dfs(matrix, i, j));
            }
        }
        return max;
    }
    
    public int dfs(int[][] matrix, int row, int col) {
        if (cache[row][col] != 0) return cache[row][col];
        
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && matrix[newRow][newCol] > matrix[row][col]) cache[row][col] = Math.max(cache[row][col], dfs(matrix, newRow, newCol));
        }
        cache[row][col]++;
        return cache[row][col];
    }
}