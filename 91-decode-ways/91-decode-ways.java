class Solution {
    public int numDecodings(String s) {
        int[] memo = new int[s.length() + 1];
        Arrays.fill(memo, -1);
        return dp(s, 0, memo);
    }
    
    public int dp(String s, int indx, int[] memo) {
        if (memo[indx] != -1) {
            return memo[indx];
        }
        
        if (indx == s.length()) {
            return 1;
        }
        
        if (s.charAt(indx) == '0') {
            return 0;
        }
        
        if (indx == s.length() - 1) {
            return 1;
        }
        int res = dp(s, indx + 1, memo);
        if (Integer.valueOf(s.substring(indx, indx + 2)) <= 26) {
            res += dp(s, indx + 2, memo);
        }
        memo[indx] = res;
        return res;
    }
}