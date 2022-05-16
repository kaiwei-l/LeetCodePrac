class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int[] memo = new int[n];
        memo[0] = nums[0];
        memo[1] = Math.max(nums[1], memo[0]);
        for (int i = 2; i < n; i++) {
            memo[i] = Math.max(memo[i - 1], nums[i] + memo[i - 2]);
        }
        return memo[n - 1];
    }
}