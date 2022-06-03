class Solution {
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int m;
    int n;
    
    public int shortestPath(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        boolean[][][] visited =  new boolean[m][n][k + 1];
        visited[0][0][k] = true;
        q.addLast(new int[]{0, 0, k});
        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] node = q.removeFirst();
                int row = node[0];
                int col = node[1];
                int token = node[2];
                if (row == (m - 1) && col == (n - 1)) return steps;
                
                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                        int newToken = token - grid[newRow][newCol];
                        if (newToken >= 0 && !visited[newRow][newCol][newToken]) {
                            q.addLast(new int[]{newRow, newCol, newToken});
                            visited[newRow][newCol][newToken] = true;
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}