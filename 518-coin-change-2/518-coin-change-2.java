class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[amount + 1][coins.length + 1];
        if (amount == 0) return 1;
        for (int i = 1; i <= amount; i++) {
            int currAmount = i;
            for (int j = 1; j < dp[i].length; j++) {
                int coin = coins[j - 1];
                if (coin == currAmount) {
                    dp[currAmount][j]++;
                    dp[currAmount][j] += dp[currAmount][j - 1];
                } else if (coin < currAmount) {
                    dp[currAmount][j] += dp[currAmount - coin][j];
                    dp[currAmount][j] += dp[currAmount][j - 1];
                } else {
                    dp[currAmount][j] = dp[currAmount][j - 1];
                }
            }
        }
        return dp[amount][coins.length];
    }
}