class Solution {
    public int consecutiveNumbersSum(int n) {
        int count = 0;
        int upperLimit = (int)(Math.sqrt(2*n + 0.25) - 0.5);
        for (int k = 1; k <= upperLimit; k++) {
            if ((n - k * (k + 1) / 2) % k == 0) count++;
        }
        return count;
    }
}