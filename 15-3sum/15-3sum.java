class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3) return ans;
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int complement = -1 * nums[i];
                int left = i + 1;
                int right = n - 1;
                while (left < right) {
                    if (nums[left] + nums[right] == complement) {
                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        ans.add(temp);
                        left++;
                        while (left < right && nums[left] == nums[left - 1]) {
                            left++;
                        }
                    } else if (nums[left] + nums[right] > complement) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return ans;
    }
}