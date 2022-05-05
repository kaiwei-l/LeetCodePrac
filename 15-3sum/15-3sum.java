class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        
        if (nums.length < 3) return ans;
        
        int i = 0;
        while (i < nums.length - 2) {
            int goal = 0 - nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            twoSum(i, left, right, goal, ans, nums);
            i++;
            while (i < nums.length && nums[i - 1] == nums[i]) {
                i++;
            }
        }
        return ans;
    }
    public void twoSum(int start, int left, int right, int goal, List<List<Integer>> ans, int[] nums) {
        while(left < right) {
            if (nums[left] + nums[right] == goal) {
                List<Integer> triple = new ArrayList<>();
                triple.add(nums[start]);
                triple.add(nums[left]);
                triple.add(nums[right]);
                ans.add(triple);
                left++;
                while (left < right && nums[left] == nums[left - 1]) {
                    left++;
                }
            } else if (nums[left] + nums[right] < goal) {
                left++;
            } else {
                right--;
            }
        }
    }
}