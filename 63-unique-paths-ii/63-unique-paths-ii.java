class Solution {
    int ans;
    int m;
    int n;
    int[][] directions = new int[][]{{0, 1}, {1, 0}};
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        ans = 0;
        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;
        obstacleGrid[0][0] = 1;
        for (int i = 1; i < n; i++) {
            obstacleGrid[0][i] = (obstacleGrid[0][i] == 1) ? 0 : obstacleGrid[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            obstacleGrid[i][0] = (obstacleGrid[i][0] == 1) ? 0 : obstacleGrid[i - 1][0];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                obstacleGrid[i][j] = (obstacleGrid[i][j] == 1) ? 0 : (obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1]);
            }
        }
        return obstacleGrid[m - 1][n - 1];
    }
}