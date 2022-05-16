class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int twoSteps = nums[0];
        int oneStep = Math.max(nums[1], nums[0]);
        for (int i = 2; i < n; i++) {
            int temp = Math.max(oneStep, nums[i] + twoSteps);
            twoSteps = oneStep;
            oneStep = temp;
        }
        return oneStep;
    }
}