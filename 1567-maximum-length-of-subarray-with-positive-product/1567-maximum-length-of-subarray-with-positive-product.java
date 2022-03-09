class Solution {
    public int getMaxLen(int[] nums) {
        int firstNegative = -1, zeroPosition = -1, countNegative = 0, max = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                countNegative++;
                if (firstNegative == -1) firstNegative = i;
            }
            if (nums[i] == 0) {
                zeroPosition = i;
                countNegative = 0;
                firstNegative = -1;
            } else {
                if (countNegative % 2 == 0) {
                    max = Math.max(i - zeroPosition, max);
                } else {
                    max = Math.max(i - firstNegative, max);
                }
            }
        }
        return max;
    }
}