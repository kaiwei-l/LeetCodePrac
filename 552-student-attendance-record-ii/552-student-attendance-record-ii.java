class Solution {
    public int checkRecord(int n) {
        long m = 1000000007;
        long[] memo = new long[n <= 5 ? 6 : n + 1];
        memo[0] = 1;
        memo[1] = 2;
        memo[2] = 4;
        memo[3] = 7;
        for (int i = 4; i <= n; i++) {
            memo[i] = (2 * memo[i - 1]) % m + (m - memo[i - 4]) % m;
        }
        
        long ans = memo[n];
        for (int i = 1; i <= n; i++) {
            ans += (memo[i - 1] * memo[n - i]) % m;
        }
        return (int)(ans % m);
    }
}