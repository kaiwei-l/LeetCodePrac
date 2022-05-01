class Solution {
    public int climbStairs(int n) {
        int oneStepBefore = 1;
        int twoStepsBefore = 1;
        int ans;
        if (n == 1) return 1;
        for (int i = 2; i <= n; i++) {
            ans = oneStepBefore + twoStepsBefore;
            twoStepsBefore = oneStepBefore;
            oneStepBefore = ans;
        }
        return oneStepBefore;
    }

}