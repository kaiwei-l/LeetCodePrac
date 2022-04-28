class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int low = i + 1;
            int high = nums.length - 1;
            while (low < high) {
                int sum = nums[i] + nums[low] + nums[high];
                if (sum == target) {
                    return sum;
                } 
                if (Math.abs(target - sum) < Math.abs(minDiff)) {
                    minDiff = target - sum;
                } 
                if (sum > target) {
                    high--;
                } else {
                    low++;
                }
            }
        }
        return target - minDiff;
    }
}