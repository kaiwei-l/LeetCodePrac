class Solution {
    public boolean judgeCircle(String moves) {
        int row = 0;
        int col = 0;
        for (int i = 0; i < moves.length(); i++) {
            char currDir = moves.charAt(i);
            if (currDir == 'U') {
                row++;
            } else if (currDir == 'D') {
                row--;
            } else if (currDir == 'L') {
                col--;
            } else {
                col++;
            }
        }
        if (row == 0 && col == 0) return true;
        return false;
    }
}