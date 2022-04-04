class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        Integer minSub = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int subSum = nums[left];
        while (left != nums.length && right != nums.length) {
            if (subSum < target) {
                right++;
                if (right != nums.length) subSum += nums[right];
            } else {
                minSub = Math.min(minSub, right - left + 1);
                while (left <= right) {
                    subSum -= nums[left];
                    left++;
                    if (subSum >= target) {
                        minSub = Math.min(minSub, right - left + 1);
                    } else {
                        break;
                    }
                }
            }
        }
        if (minSub == Integer.MAX_VALUE) return 0;
        return minSub;
    }
}