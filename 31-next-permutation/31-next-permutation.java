class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        for (int indx = n - 1; indx > 0; indx--) {
            if (nums[indx] > nums[indx - 1]) {
                int rightMin = n - 1;
                while (nums[rightMin] <= nums[indx - 1]) {
                    rightMin--;
                }
                swap(nums, rightMin, indx - 1);
                reverse(nums, indx, n - 1);
                return;
            }
        }
        reverse(nums, 0, n - 1);
    }
    
    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
    
    public void reverse(int[] nums, int left, int right) {
        while (left <= right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
}