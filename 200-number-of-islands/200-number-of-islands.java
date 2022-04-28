class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        boolean[][] visited = new boolean[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    visited[i][j] = true;
                    ArrayDeque<Pair<Integer, Integer>> stack = new ArrayDeque<>();
                    stack.add(new Pair(i, j));
                    dfs(visited, grid, stack);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void dfs(boolean[][] visited, char[][] grid, ArrayDeque<Pair<Integer, Integer>> stack) {
        while (!stack.isEmpty()) {
            Pair<Integer, Integer> p = stack.removeLast();
            int row = p.getKey();
            int col = p.getValue();
            for (int rowChange = -1; rowChange < 2; rowChange++) {
                int newRow = row + rowChange;
                if (canVisit(newRow, col, grid.length, grid[0].length) && !visited[newRow][col] && grid[newRow][col] == '1') {
                    visited[newRow][col] = true;
                    stack.addLast(new Pair(newRow, col));
                    dfs(visited, grid, stack);
                }
            }
            for (int colChange = -1; colChange < 2; colChange++) {
                int newCol = col + colChange;
                if (canVisit(row, newCol, grid.length, grid[0].length) && !visited[row][newCol] && grid[row][newCol] == '1') {
                    visited[row][newCol] = true;
                    stack.addLast(new Pair(row, newCol));
                    dfs(visited, grid, stack);
                }
            }
        }
    }
    
    private boolean canVisit(int row, int col, int rowLimit, int colLimit) {
        if (row >= 0 && row < rowLimit && col >= 0 && col < colLimit) {
            return true;
        }
        return false;
    }
    
    
}