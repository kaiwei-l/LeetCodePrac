class Solution {
    public int minSwaps(int[] data) {
        int oneCount = 0;
        int n = data.length;
        int[] memo = new int[n];
        memo[0] = (data[0] == 0) ? 0 : 1;
        for (int i = 1; i < n; i++) {
            memo[i] = memo[i - 1] + ((data[i] == 1) ? 1 : 0);
        }
        oneCount = memo[n - 1];
        int minMoves = Integer.MAX_VALUE;
        int windowSize = oneCount;
        if (windowSize == 0) return 0;
        for (int right = oneCount - 1; right < n; right++) {
            int left = right - oneCount + 1;
            int zeroCount = 0;
            if (left == 0) {
                zeroCount = windowSize - memo[right];
            } else {
                zeroCount = windowSize - memo[right] + memo[left - 1];
            }
            minMoves = Math.min(minMoves, zeroCount);
        }
        return minMoves;
        
    }
}