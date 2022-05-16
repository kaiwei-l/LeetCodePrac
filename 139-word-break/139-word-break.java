class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length()];
        return dp(s, 0, memo, wordDict);
    }
    
    public boolean dp(String s, int start, Boolean[] memo, List<String> wordDict) {
        if (start == s.length()) {
            return true;
        }
        if (memo[start] != null) {
            return memo[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && dp(s, end, memo, wordDict)) {
                memo[start] = true;
                return memo[start];
            }
        }
        memo[start] = false;
        return memo[start];
    }
}