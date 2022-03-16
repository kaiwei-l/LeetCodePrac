class Solution {
    public boolean canVisit(int row, int col, int rowLimit, int colLimit) {
        if (row >= 0 && row < rowLimit && col >= 0 && col < colLimit) return true;
        return false;
    }
    
    public boolean dfs(ArrayDeque<Pair<Integer, Integer>> stack, int rowLimit, int colLimit, char[][] board, String word, int wordIndx) {
        wordIndx++;
        while (!stack.isEmpty() && wordIndx < word.length()) {
            Pair<Integer, Integer> cell = stack.removeLast();
            int row = cell.getKey();
            int col = cell.getValue();
            char currC = board[row][col];
            board[row][col] = '1';
            for (int rowChange = -1; rowChange < 2; rowChange++) {
                int newRow = row + rowChange;
                if (canVisit(newRow, col, rowLimit, colLimit) && word.charAt(wordIndx) == board[newRow][col] && board[newRow][col] != '1') {
                    stack.add(new Pair(newRow, col));
                    boolean res = dfs(stack, rowLimit, colLimit, board, word, wordIndx);
                    if (res) {
                        board[row][col] = currC;
                        return true;
                    }
                }
            }
            for (int colChange = -1; colChange < 2; colChange++) {
                int newCol = col + colChange;
                if (canVisit(row, newCol, rowLimit, colLimit) && word.charAt(wordIndx) == board[row][newCol] && board[row][newCol] != '1') {
                    stack.add(new Pair(row, newCol));
                    boolean res = dfs(stack, rowLimit, colLimit, board, word, wordIndx);
                    if (res) {
                        board[row][col] = currC;
                        return true;
                    }
                }
            }
            board[row][col] = currC;
        }
        if (wordIndx == word.length()) return true;
        return false;
    }
    
    public boolean exist(char[][] board, String word) {
        int rowLimit = board.length;
        int colLimit = board[0].length;
        ArrayDeque<Pair<Integer, Integer>> stack = new ArrayDeque<>();
        int wordIndx = 0;
        for (int i = 0; i < rowLimit; i++) {
            for (int j = 0; j < colLimit; j++) {
                if (board[i][j] == word.charAt(0)) {
                    stack.add(new Pair(i, j));
                    boolean res = dfs(stack, rowLimit, colLimit, board, word, wordIndx);
                    if (res) return true;
                }
            }
        }
        return false;
    }
}