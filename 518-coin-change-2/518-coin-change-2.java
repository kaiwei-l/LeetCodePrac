class Solution {
    public int change(int amount, int[] coins) {
        int[] memo = new int[amount + 1];
        memo[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (coin <= i) {
                    memo[i] += memo[i - coin];
                }
            }
        }
        return memo[amount];
    }
}