class Solution {
    public int change(int amount, int[] coins) {
        int[] memo = new int[amount + 1];
        memo[0] = 1;
        for (int c : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i >= c) memo[i] += memo[i - c];
            }
        }
        return memo[amount];
    }
}