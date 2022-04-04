class Solution {
    public int fib(int n) {
        int prev = 0;
        int curr = 1;
        if (n == 0) return 0;
        if (n == 1) return 1;
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            ans = prev + curr;
            prev = curr;
            curr = ans;
        } 
        return ans;
    }
}