class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int n = nums.length;
        if (n < 3) return ans;
        Arrays.sort(nums);
        
        int indx = 0;
        while (indx < n - 2) {
            int complement = -1 * nums[indx];
            int left = indx + 1;
            int right = n - 1;
            while (left < right) {
                if (nums[left] + nums[right] == complement) {
                    List<Integer> res = new ArrayList<Integer>();
                    res.add(nums[indx]);
                    res.add(nums[left]);
                    res.add(nums[right]);
                    ans.add(res);
                    left++;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else if (nums[left] + nums[right] < complement) {
                    left++;
                } else {
                    right--;
                }
            }
            indx++;
            while (indx < n - 2 && nums[indx] == nums[indx - 1]) {
                indx++;
            }
        }
        return ans;
    }
}