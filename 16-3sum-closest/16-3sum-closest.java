class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int diff = Integer.MAX_VALUE;
        int ans = 0;
        
        Arrays.sort(nums);
        int i = 0;
        while (i < n - 2) {
            if (i != 0 && nums[i] == nums[i - 1]) {
                i++;
            } else {
                int complement = target - nums[i];
                int left = i + 1;
                int right = n - 1;
                while (left < right) {
                    int res = nums[left] + nums[right];
                    if (Math.abs(complement - res) < diff) {
                        diff = Math.abs(complement - res);
                        ans = nums[i] + nums[left] + nums[right];
                    }
                    if (res > complement) {
                        right--;
                    } else if (res == complement) {
                        break;
                    } else {
                        left++;
                    }
                }
                i++;   
            }
        }
        return ans;
    }
}