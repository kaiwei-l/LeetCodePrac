class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        int low = 0;
        int high = nums.length - 1;
        if (nums[low] < nums[high]) return nums[low];
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            } else if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            } else if (nums[mid] > nums[0]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return nums[low];
    }
}