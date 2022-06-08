class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int currSum = 0;
        int ans = nums.length + 1;
        for (int right = 0; right < nums.length; right++) {
            currSum += nums[right];
            if (currSum >= target) {
                while (left <= right && currSum >= target) {
                    ans = Math.min(ans, right - left + 1);
                    currSum -= nums[left];
                    left++;
                }
            }
        }
        return (ans == nums.length + 1) ? 0 : ans;
    }
}