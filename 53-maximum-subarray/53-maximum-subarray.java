class Solution {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int left = 0;
        int currSum = nums[0];
        for (int right = 1; right < nums.length; right++) {
            if (nums[right] > currSum + nums[right]) {
                currSum = nums[right];
            } else {
                currSum += nums[right];
            }
            ans = Math.max(ans, currSum);
        }
        return ans;
    }
}