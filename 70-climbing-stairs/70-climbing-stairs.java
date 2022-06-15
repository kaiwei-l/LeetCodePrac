class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int oneStep = 2;
        int twoStep = 1;
        for (int i = 3; i <= n; i++) {
            int temp = oneStep + twoStep;
            twoStep = oneStep;
            oneStep = temp;
        }
        return oneStep;
    }
}