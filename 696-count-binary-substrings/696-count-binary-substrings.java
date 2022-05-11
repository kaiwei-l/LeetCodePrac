class Solution {
    public int countBinarySubstrings(String s) {
        int ans = 0;
        for (int right = 1; right < s.length(); right++) {
            if ((s.charAt(right - 1) == '1' && s.charAt(right) == '0') || (s.charAt(right - 1) == '0' && s.charAt(right) == '1')) {
                ans++;
                int newRight = right + 1;
                int newLeft = right - 2;
                while (newLeft >= 0 && newRight < s.length()) {
                    if (s.charAt(newLeft) == s.charAt(newLeft + 1) && s.charAt(newRight) == s.charAt(newRight - 1)) {
                        ans++;
                        newLeft--;
                        newRight++;
                    } else {
                        break;
                    }
                }
            }
        }
        return ans;
    }
}