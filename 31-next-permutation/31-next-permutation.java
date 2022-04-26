class Solution {
    public void exchange(int left, int right, int[] nums) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    
    public void nextPermutation(int[] nums) {
        int midPoint = -1;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                int swapPoint = i;
                for (int indx = i; indx < nums.length; indx++) {
                    if (nums[i - 1] < nums[indx]) {
                        swapPoint = indx;
                    }
                }
                exchange(i - 1, swapPoint, nums);
                midPoint = i;
                break;
            }
        }
        int left = (midPoint == -1) ? 0 : midPoint;
        int right = nums.length - 1;
        while (left < right) {
            exchange(left, right, nums);
            left++;
            right--;
        }
    }
}