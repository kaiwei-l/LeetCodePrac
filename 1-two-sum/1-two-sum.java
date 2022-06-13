class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (counter.containsKey(complement)) {
                ans[0] = i;
                ans[1] = counter.get(complement);
                return ans;
            }
            counter.put(nums[i], i);
        }
        return null;
    }
}