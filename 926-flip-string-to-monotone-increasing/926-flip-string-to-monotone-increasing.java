class Solution {
    public int minFlipsMonoIncr(String s) {
        int n = s.length();
        int[] memo = new int[n + 1];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            memo[i + 1] = memo[i] + ((c == '1') ? 1 : 0);
        }
        
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            ans = Math.min(ans, memo[i] + (n - i) - (memo[n] - memo[i]));
        }
        return ans;
    }
}