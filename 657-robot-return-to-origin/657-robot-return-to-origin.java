class Solution {
    public void move(Character currMove, int[] position) {
        if (currMove.equals('U')) {
            position[0] += 1;
        } else if (currMove.equals('D')) {
            position[0] -= 1;
        } else if (currMove.equals('L')) {
            position[1] -= 1;
        } else {
            position[1] += 1;
        }
    }
    public boolean judgeCircle(String moves) {
        int[] position = new int[2];
        position[0] = 0;
        position[1] = 0;
        for (int i = 0; i < moves.length(); i++) {
            move(moves.charAt(i), position);
        }
        if (position[0] == 0 && position[1] == 0) {
            return true;
        }
        return false;
    }
}