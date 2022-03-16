class TicTacToe {
    public int[][] board;
    public int n;
    
    public TicTacToe(int n) {
        this.n = n;
        this.board = new int[n][n];
    }
    
    public int move(int row, int col, int player) {
        board[row][col] = player;
        if (checkRow(row, player) || checkCol(col, player) || (row == col && checkDiagonal(player)) || (col == n - row - 1 && checkAntiDiagonal(player))) {
            return player;
        }
        return 0;
    }
    
    public boolean checkDiagonal(int player) {
        for (int row = 0; row < n; row++) {
            if (board[row][row] != player) return false;
        }
        return true;
    }
    
    public boolean checkAntiDiagonal(int player) {
        for (int row = 0; row < n; row++) {
            if (board[row][n - row - 1] != player) return false;
        }
        return true;
    }
    
    public boolean checkRow(int row, int player) {
        for (int col = 0; col < n; col++) {
            if (board[row][col] != player) return false;
        }
        return true;
    }
    
    public boolean checkCol(int col, int player) {
        for (int row = 0; row < n; row++) {
            if (board[row][col] != player) return false;
        }
        return true;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */