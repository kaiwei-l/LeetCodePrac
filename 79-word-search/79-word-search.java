class Solution {
    int m;
    int n;
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public boolean exist(char[][] board, String word) {
        HashSet<Pair<Integer, Integer>> visited = new HashSet<>();
        int indx = 0;
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (word.charAt(indx) == board[i][j]) {
                    Pair<Integer, Integer> point = new Pair(i, j);
                    visited.add(point);
                    boolean res = dfs(board, word, visited, point, indx + 1);
                    if (res) return true;
                    indx = 0;
                    visited.clear();
                }
            }
        }
        return false;
    }
    
    public boolean dfs(char[][] board, String word, HashSet<Pair<Integer, Integer>> visited, Pair<Integer, Integer> point, int indx) {
        if (indx == word.length()) return true;
        int row = point.getKey();
        int col = point.getValue();
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            Pair<Integer, Integer> newPoint = new Pair(newRow, newCol);
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited.contains(newPoint) && board[newRow][newCol] == word.charAt(indx)) {
                visited.add(newPoint);
                boolean res = dfs(board, word, visited, newPoint, indx + 1);
                if (res) return res;
                visited.remove(newPoint);
            }
        }
        return false;
    }
}