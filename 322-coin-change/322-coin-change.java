class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int n = coins.length;
        int[][] dp = new int[amount + 1][n + 1];
        
        for (int i = 0; i < n + 1; i++) dp[0][i] = 0;
        for (int value = 1; value <= amount; value++) dp[value][0] = -1;
        for (int value = 1; value <= amount; value++) {
            for (int i = 1; i < n + 1; i++) {
                int coin = coins[i - 1];
                if (coin > value) {
                    dp[value][i] = dp[value][i - 1];
                } else if (coin == value) {
                    dp[value][i] = 1;
                } else {
                    if (dp[value][i - 1] != -1 && dp[value - coin][i] != -1) {
                        dp[value][i] = Math.min(dp[value - coin][i] + 1, dp[value][i - 1]);
                    } else if (dp[value][i - 1] != -1) {
                        dp[value][i] = dp[value][i - 1];
                    } else if (dp[value - coin][i] != -1){
                       dp[value][i] = dp[value - coin][i] + 1; 
                    } else {
                        dp[value][i] = -1;
                    }
                }
            }
        }
        return dp[amount][n];
    }
}