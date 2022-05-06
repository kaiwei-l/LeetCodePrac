class Solution {
    public int climbStairs(int n) {
        int twoBack = 1;
        int oneBack = 1;
        if (n == 1) {
            return oneBack;
        }
        for (int i = 2; i <= n; i++) {
            int temp = oneBack + twoBack;
            twoBack = oneBack;
            oneBack = temp;
        }
        return oneBack;
    }
}