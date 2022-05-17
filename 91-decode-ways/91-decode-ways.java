class Solution {
    public int numDecodings(String s) {
        int[] memo = new int[s.length() + 1];
        memo[0] = 1;
        memo[1] = ((s.charAt(0) == '0') ? 0 : 1);
        for (int i = 1; i < s.length(); i++) {
            int indx = i + 1;
            if (s.charAt(i) != '0') {
                memo[indx] += memo[indx - 1];
            }
            int twoDigit = Integer.valueOf(s.substring(i - 1, i + 1));
            if (twoDigit <= 26 && twoDigit >= 10) {
                memo[indx] += memo[indx - 2];
            }
        }
        return memo[s.length()];
    }
}