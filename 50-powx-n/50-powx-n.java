class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        long N = n;
        if (N < 0) {
            N = -N;
            x = 1 / x;
        }
        
        return fastPow(x, N);
    }
    
    public double fastPow(double x, long n) {
        if (n == 0) return 1;
        
        double half = fastPow(x, n / 2);
        if (n % 2 != 0) {
            return x * half * half;
        } else {
            return half * half;
        }
    }
}
