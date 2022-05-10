class Solution {
    public int uniqueLetterString(String s) {
        int ans = 0;
        int[] lastPosition = new int[26];
        int[] contribution = new int[26];
        
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'A';
            int numberOfSubstringEndsHere = i + 1;
            contribution[c] = numberOfSubstringEndsHere - lastPosition[c];
            int curr = 0;
            for (int j : contribution) {
                curr += j;
            }
            ans += curr;
            lastPosition[c] = i + 1;
        }
        return ans;
    }
}