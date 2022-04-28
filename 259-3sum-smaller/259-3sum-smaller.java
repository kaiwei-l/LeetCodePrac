class Solution {
    public int threeSumSmaller(int[] nums, int target) {
        int count = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            count += twoSumAux(nums, i + 1, target - nums[i]);
        }
        return count;
    }
    
    private int twoSumAux(int[] nums, int indx, int goal) {
        int low = indx;
        int high = nums.length - 1;
        int count = 0;
        while (low < high) {
            int sum = nums[low] + nums[high];
            if (sum >= goal) {
                high--;
            } else {
                count += (high - low);
                low++;
            }
        }
        return count;
    }
}