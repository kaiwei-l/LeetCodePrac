class Solution {
    public int numDecodings(String s) {
        if (s.charAt(0) == '0') return 0;
        if (s.length() == 1) return 1;
        int[] memo = new int[s.length() + 1];
        memo[0] = 1;
        memo[1] = (s.charAt(0) == '0') ? 0 : 1;
        
        for (int i = 2; i < memo.length; i++) {
            int strIndx = i - 1;
            if (s.charAt(strIndx) != '0') {
                memo[i] = memo[i - 1];
            } else {
                memo[i] = 0;
            }
            
            int twoDigit = Integer.valueOf(s.substring(strIndx - 1, strIndx + 1));
            if (twoDigit <= 26 && twoDigit >= 10) {
                memo[i] += memo[i - 2];
            }
        }
        return memo[s.length()];
    }
    
    
    
}