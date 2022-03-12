class Solution {
    public boolean canVisit(int row, int col, int rowLimit, int colLimit) {
        if (row >= 0 && row < rowLimit && col >= 0 && col < colLimit) return true;
        return false;
    }
    
    public int getFood(char[][] grid) {
        int rowLimit = grid.length;
        int colLimit = grid[0].length;
        Pair<Integer, Integer> location;
        int steps = 0;
        Queue<Pair<Integer, Integer>> q = new ArrayDeque();        
        for (int i = 0; i < rowLimit; i++) {
            for (int j = 0; j < colLimit; j++) {
                if (grid[i][j] == '*') {
                    q.offer(new Pair(i, j));
                    grid[i][j] = 'V';
                }
            }
        }
        q.offer(new Pair(-1, -1));
        // BFS
        while (!q.isEmpty()) {
            Pair<Integer, Integer> p = q.poll();
            int row = p.getKey();
            int col = p.getValue();
            if (row == -1 && col == -1) {
                steps++;
                if (!q.isEmpty()) q.offer(new Pair(-1, -1));
            } 
            for (int rowChange = -1; rowChange < 2; rowChange++) {
                int newRow = row + rowChange;
                if (canVisit(newRow, col, rowLimit, colLimit) && grid[newRow][col] == '#') return ++steps;
                if (canVisit(newRow, col, rowLimit, colLimit) && grid[newRow][col] == 'O') {
                    grid[newRow][col] = 'V';
                    q.offer(new Pair(newRow, col));
                }
            }
            for (int colChange = -1; colChange < 2; colChange++) {
                int newCol = col + colChange;
                if (canVisit(row, newCol, rowLimit, colLimit) && grid[row][newCol] == '#') return ++steps;
                if (canVisit(row, newCol, rowLimit, colLimit) && grid[row][newCol] == 'O') {
                    grid[row][newCol] = 'V';
                    q.offer(new Pair(row, newCol));
                }
            }
        }
        return -1;
    }
}