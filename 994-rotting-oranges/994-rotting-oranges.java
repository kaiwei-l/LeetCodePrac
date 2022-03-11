class Solution {
    public int orangesRotting(int[][] grid) {
        int ans = 0, freshCount = 0;
        int[] res = new int[2];
        Queue<int[]> q = new LinkedList<int[]>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    freshCount++;
                } else if (grid[i][j] == 2) {
                    q.add(new int[]{i, j});
                }
            }
        }
        res = bfs(grid, ans, freshCount, q);
        ans = res[0];
        freshCount = res[1];
        if (freshCount == 0) {
            return ans;
        } else {
            return -1;
        }
    }
    
    public boolean canVisit(int row, int col, int rowLimit, int colLimit) {
        if (row >= 0 && row < rowLimit && col >= 0 && col < colLimit) {
            return true;
        }
        return false;
    }
    
    public int[] bfs(int[][] grid, int ans, int freshCount, Queue<int[]> currQ) {
        int rowLimit = grid.length, colLimit = grid[0].length;
        Queue<int[]> newQ = new LinkedList<int[]>();
        boolean qNotEmpty = true;
        while (qNotEmpty) {
            while (!currQ.isEmpty()) {
                int[] p = currQ.remove();
                int currRow = p[0];
                int currCol = p[1];
                grid[currRow][currCol] = -1;
                for (int rowChange = -1; rowChange < 2; rowChange++) {
                    int newRow = currRow + rowChange;
                    if (canVisit(newRow, currCol, rowLimit, colLimit) && grid[newRow][currCol] == 1) {
                        grid[newRow][currCol] = -1;
                        freshCount--;
                        newQ.add(new int[]{newRow, currCol});
                    }
                }
                for (int colChange = -1; colChange < 2; colChange++) {
                    int newCol = currCol + colChange;
                    if (canVisit(currRow, newCol, rowLimit, colLimit) && grid[currRow][newCol] == 1) {
                        grid[currRow][newCol] = -1;
                        freshCount--;
                        newQ.add(new int[]{currRow, newCol});
                    }
                }
            }
            if (newQ.isEmpty()) {
                qNotEmpty = false;
            } else {
                ans += 1;
                currQ = newQ;
                newQ = new LinkedList<int[]>();
            }
        }
        return new int[]{ans, freshCount};
    }
}