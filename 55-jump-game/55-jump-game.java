class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        
        int leftMost = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            for (int step = 1; step <= nums[i]; step++) {
                if (i + step >= leftMost) {
                    leftMost = i;
                    break;
                }
            }
        }
        return leftMost == 0;
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