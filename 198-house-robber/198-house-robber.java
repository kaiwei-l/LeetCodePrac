class Solution {
    public int rob(int[] nums) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        return dp(0, nums, memo);
    }
    
    public int dp(int curr, int[] nums, HashMap<Integer, Integer> memo) {
        if (curr >= nums.length) {
            return 0;
        }
        if (memo.containsKey(curr)) {
            return memo.get(curr);
        }
        if (curr == nums.length - 1) {
            memo.put(curr, nums[curr]);
            return nums[curr];
        }
        int temp = Math.max(nums[curr] + dp(curr + 2, nums, memo), dp(curr + 1, nums, memo));
        memo.put(curr, temp);
        return temp;
    }
}