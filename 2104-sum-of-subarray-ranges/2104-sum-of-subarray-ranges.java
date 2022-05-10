class Solution {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        long[][][] memo = new long[n][n][2];
        for (int i = 0; i < n; i++) {
            // (MIN, MAX)
            memo[i][i][0] = nums[i];
            memo[i][i][1] = nums[i];
        }
        long ans = 0;
        for (int right = 1; right < n; right++) {
            for (int left = right - 1; left >= 0; left--) {
                long prevMin = memo[left][right - 1][0];
                long prevMax = memo[left][right - 1][1];
                long max = Math.max(nums[right], prevMax);
                long min = Math.min(nums[right], prevMin);
                ans += max - min;
                memo[left][right][0] = min;
                memo[left][right][1] = max;
            }
        }
        return ans;
    }
}