class Solution {
    public boolean placeWordInCrossword(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        int k = word.length();
        int[][] directions = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] dir : directions) {
                    int rBeforeStart = i - dir[0];
                    int cBeforeStart = j - dir[1];
                    if (rBeforeStart >= 0 && rBeforeStart < m && cBeforeStart >= 0 && cBeforeStart < n && board[rBeforeStart][cBeforeStart] != '#') continue;
                    
                    int rAfterEnd = i + dir[0] * k;
                    int cAfterEnd = j + dir[1] * k;
                    if (rAfterEnd >= 0 && rAfterEnd < m && cAfterEnd >= 0 && cAfterEnd < n && board[rAfterEnd][cAfterEnd] != '#') continue;
                    
                    int lastR = i + dir[0] * (k - 1);
                    int lastC = j + dir[1] * (k - 1);
                    if (lastR < 0 || lastR >= m || lastC < 0 || lastC >= n) continue;
                    
                    int token = 0;
                    int row = i;
                    int col = j;
                    while (token < k) {
                        if (board[row][col] != ' ' && board[row][col] != word.charAt(token)) break;
                        row += dir[0];
                        col += dir[1];
                        token++;
                    }
                    
                    if (token == k) return true;
                }
            }
        }
        return false;
    }
}