class Solution {
    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    
    public String fractionAddition(String expression) {
        int denominator = 1;
        int numerator = 0;
        for (int i = 0; i < expression.length(); i++) {
            char currChar = expression.charAt(i);
            if (currChar == '/') {
                int num;
                if (i + 2 < expression.length() && expression.charAt(i + 2) == '0') {
                    num = 10;
                } else {
                    num = Character.getNumericValue(expression.charAt(i + 1));
                }
                denominator *= num;
            }
        }
        for (int i = 0; i < expression.length(); i++) {
            char currChar = expression.charAt(i);
            if (currChar == '/') {
                if (i != 1) {
                    int currNumer;
                    int currDenom;
                    char sign = '+';
                    if (expression.charAt(i - 2) == '1') {
                        currNumer = 10;
                        if (i != 2) sign = expression.charAt(i - 3);
                    } else {
                        currNumer = Character.getNumericValue(expression.charAt(i - 1));
                        sign = expression.charAt(i - 2);
                    }
                    if (i + 2 < expression.length() && expression.charAt(i + 2) == '0') {
                        currDenom = 10;
                    } else {
                        currDenom = Character.getNumericValue(expression.charAt(i + 1));
                    }
                    if (sign == '-') {
                        currNumer*= (-1) * (denominator / currDenom);
                    } else {
                        currNumer*= (denominator / currDenom);
                    }
                    numerator += currNumer;
                } else {
                    int currNumer;
                    int currDenom;
                    currNumer = Character.getNumericValue(expression.charAt(i - 1));
                    if (i + 2 < expression.length() && expression.charAt(i + 2) == '0') {
                        currDenom = 10;
                    } else {
                        currDenom = Character.getNumericValue(expression.charAt(i + 1));
                    }
                    currNumer*= (denominator / currDenom);
                    numerator += currNumer;
                }
            }
        }
        int sign = 1;
        if (numerator < 0) {
            numerator *= -1;
            sign = -1;
        } 
        int gcdNum = gcd(numerator, denominator);
        numerator /= gcdNum;
        denominator /= gcdNum;
        String ans;
        if (sign < 0) {
            ans = "-" + String.valueOf(numerator) + "/" + String.valueOf(denominator);
        } else {
            ans = String.valueOf(numerator) + "/" + String.valueOf(denominator);
        }
        return ans;
    }
}