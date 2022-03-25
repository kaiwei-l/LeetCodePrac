class Solution {
    public int sumSubseqWidths(int[] nums) {
        Arrays.sort(nums);
        long c = 1;
        long res = 0;
        long mod = 1_000_000_007;
        int n = nums.length;
        for (int i = 0; i < n; ++i, c = c * 2 % mod) {
            res = (res + nums[i] * c - nums[n - i - 1] * c) % mod;
        }
        return (int)((res + mod) % mod);
    }
}