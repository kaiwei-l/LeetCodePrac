class Solution {
    private int ans = 0;
    
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int n = s.length();
        for (int i = 0; i < n; i++) {
            countAux(s, i, i);
            countAux(s, i, i + 1);
        }
        return ans;
    }
    
    public void countAux(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            ans++;
            left--;
            right++;
        }
    }
}