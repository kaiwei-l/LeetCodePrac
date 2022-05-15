class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if (nums[0] <= nums[n - 1]) return nums[0];
        
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid > 0 && nums[mid] < nums[mid - 1]) return nums[mid];
            if (mid < n - 1 && nums[mid] >= nums[0] && nums[mid] > nums[mid + 1]) return nums[mid + 1];
            if (nums[mid] > nums[0]) left = mid + 1;
            if (nums[mid] < nums[0]) right = mid - 1;
        }
        return -1;
    }
}