class Solution {
    public int pivotIndex(int[] nums) {
        int rightSum = 0;
        int leftSum = 0;
        for (int i = 1; i < nums.length; i++) {
            rightSum += nums[i];
        }
        
        for (int pivot = 0; pivot < nums.length; pivot++) {
            if (leftSum == rightSum) {
                return pivot;
            } else {
                if (pivot == nums.length - 1) break;
                leftSum += nums[pivot];
                rightSum -= nums[pivot + 1];
            }
        }
        
        return -1;
    }
}