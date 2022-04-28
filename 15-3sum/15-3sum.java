class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSum(nums, i, ans);
            }
        }
        return ans;
    }
    
    public void twoSum(int[] nums, int i, List<List<Integer>> ans) {
        int low = i + 1;
        int high = nums.length - 1;
        int goal = -1 * nums[i];
        while (low < high) {
            int sum = nums[low] + nums[high];
            if (sum == goal) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(nums[i]);
                pair.add(nums[low]);
                pair.add(nums[high]);
                ans.add(pair);
                low++;
                high--;
                while (low < high && nums[low] == nums[low - 1]) {
                    low++;
                }
            } else if (sum < goal) {
                low++;
            } else {
                high--;
            }
        }
    }
}