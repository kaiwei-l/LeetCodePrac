class Solution {
    public boolean canJump(int[] nums) {
        Boolean[] memo = new Boolean[nums.length];
        return dp(memo, nums, 0);
    }
    
    public boolean dp(Boolean[] memo, int[] nums, int indx) {
        if (memo[indx] != null) {
            return memo[indx];
        }
        if (indx == nums.length - 1) {
            memo[indx] = true;
            return true;
        }
        for (int step = 1; step <= nums[indx]; step++) {
            if (dp(memo, nums, indx + step)) {
                memo[indx] = true;
                return true;
            }
        }
        memo[indx] = false;
        return false;
    }
}