class Solution {
    public String findLongestWord(String s, List<String> dictionary) {
        String ans = "";
        for (String w : dictionary) {
            if (isSubsequence(s, w) && (w.length() > ans.length() || (w.length() == ans.length() && ans.compareTo(w) > 0))) {
                ans = w;
            }
        }
        return ans;
    }
    
    public boolean isSubsequence(String x, String y) {
        if (x.length() < y.length()) return false;
        int indxY = 0;
        for (int indxX = 0; indxX < x.length(); indxX++) {
            if (indxY < y.length() && x.charAt(indxX) == y.charAt(indxY)) {
                indxY++;
            }
        }
        return (indxY == y.length()) ? true : false;
    }
}