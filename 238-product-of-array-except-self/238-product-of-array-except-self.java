class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] ans = new int[n];
        left[0] = nums[0];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i];
        }
        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i];
        }
        
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                ans[i] = right[i + 1];
            } else if (i == n - 1) {
                ans[i] = left[i - 1];
            } else {
                ans[i] = left[i - 1] * right[i + 1];   
            }
        }
        return ans;
    }
}