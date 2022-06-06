class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int ans = 0;
        int n = s.length();
        int[] memo = new int[n];
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    memo[i] = ((i - 2 >= 0) ? memo[i - 2] : 0) + 2;
                } else if (i - memo[i - 1] > 0 && s.charAt(i - memo[i - 1] - 1) == '(') {
                    memo[i] = memo[i - 1] + ((i - memo[i - 1] >= 2) ? memo[i - memo[i - 1] - 2] : 0) + 2;
                }
                ans = Math.max(ans, memo[i]);
            }
        }
        return ans;
    }
}