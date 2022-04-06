class Solution {
    public int myAtoi(String s) {
        int i = 0;
        StringBuilder num = new StringBuilder();
        int sign = 1;
        int res = 0;
        
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        
        if (i < s.length() && s.charAt(i) == '-') {
            sign *= -1;
            i++;
        } else if (i < s.length() && s.charAt(i) == '+') {
            sign *= 1;
            i++;
        }
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int digit = Character.getNumericValue(s.charAt(i));
            if (res > max / 10 || (res == max / 10 && digit > max % 10)) {
                if (sign == 1) {
                    return max;
                } else {
                    return min;
                }
            }
            res = res * 10 + digit;
            i++;
        }
        return res * sign;
        
    }
}