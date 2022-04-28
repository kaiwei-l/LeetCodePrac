class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int curr = nums[i];
            int complement = target - curr;
            if (map.containsKey(complement)) {
                ans[0] = i;
                ans[1] = map.get(complement);
                return ans;
            } else {
                map.put(curr, i);
            }
        }
        return ans;
    }
}