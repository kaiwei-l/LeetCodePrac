class Solution {
    public int myAtoi(String s) {
        int indx = 0;
        if (s == null || s.length() == 0) return 0;
        while (indx < s.length() && s.charAt(indx) == ' ') {
            indx++;
        }
        
        int sign = 1;
        if (indx < s.length() && s.charAt(indx) == '-') {
            sign = -1;
            indx++;
        } else if (indx < s.length() && s.charAt(indx) == '+') {
            indx++;
        }
        
        int ans = 0;
        
        while (indx < s.length() && Character.isDigit(s.charAt(indx))) {
            char c = s.charAt(indx);
            int d = c - '0';
            if (ans == Integer.MAX_VALUE / 10 && d <= Integer.MAX_VALUE % 10) {
                ans = ans * 10 + d;
            } else if (ans >= Integer.MAX_VALUE / 10) {
                ans = Integer.MAX_VALUE;
                return (sign == -1) ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            } else {
                ans = ans * 10 + d;
            }
            indx++;
        }
        return (sign == 1) ? ans : -1 * ans;
    }
}