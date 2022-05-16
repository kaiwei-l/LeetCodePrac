class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        return Math.max(robAux(nums, 0, nums.length - 2), robAux(nums, 1, nums.length - 1));
    }
    
    public int robAux(int[] nums, int left, int right) {
        int n = right - left + 1;
        if (n == 1) return nums[left];
        if (n == 2) return Math.max(nums[left], nums[left + 1]);
        int twoSteps = nums[left];
        int oneStep = Math.max(twoSteps, nums[left + 1]);
        for (int i = left + 2; i <= right; i++) {
            int temp = Math.max(nums[i] + twoSteps, oneStep);
            twoSteps = oneStep;
            oneStep = temp;
        }
        return oneStep;
    }
}