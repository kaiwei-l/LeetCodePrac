class Solution {
    String ans = "";
    
    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            check(s, i, i);
            check(s, i, i + 1);
        }
        return ans;
    }
    
    public void check(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        left++;
        right--;
        if (right - left + 1 > ans.length()) {
            ans = s.substring(left, right + 1);
        }
    }
}