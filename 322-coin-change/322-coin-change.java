class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        
        int[] memo = new int[amount + 1];
        Arrays.fill(memo, amount + 1);
        memo[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int c : coins) {
                if (i >= c) {
                    memo[i] = Math.min(memo[i], memo[i - c] + 1);
                }
            }
        }
        return (memo[amount] == amount + 1) ? -1 : memo[amount];
    }
}