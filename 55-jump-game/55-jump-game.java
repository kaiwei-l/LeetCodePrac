class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        Boolean[] memo = new Boolean[n];
        
        memo[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            for (int step = 1; step <= nums[i]; step++) {
                if (i + step < n && memo[i + step] == true) {
                    memo[i] = true;
                    break;
                }
            }
            if (memo[i] == null) {
                memo[i] = false;
            }
        }
        return memo[0];
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