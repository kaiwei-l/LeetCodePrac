class Solution {
    public int consecutiveNumbersSum(int n) {
        int count = 0;
        int upperLimit = (int)(Math.sqrt(2 * n + 0.25) - 0.5);
        for (int k = 1; k <= upperLimit; k++) {
            n -= k;
            if (n % k == 0) count++;
        }
        return count;
    }
}