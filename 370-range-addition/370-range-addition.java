class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] ans = new int[length];
        for (int i = 0; i < updates.length; i++) {
            int startIndx = updates[i][0];
            int endIndx = updates[i][1];
            int val = updates[i][2];
            ans[startIndx] += val;
            if (endIndx + 1 < length) ans[endIndx + 1] -= val;
        }
        
        for (int i = 1; i < length; i++) {
            ans[i] += ans[i - 1];
        }
        return ans;
    }
}