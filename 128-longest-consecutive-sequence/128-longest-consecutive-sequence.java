class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        int ans = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        int curr = 0;
        for (int n : nums) {
            if (!set.contains(n - 1)) {
                int currNum = n;
                int currLen = 1;
                while (set.contains(currNum + 1)) {
                    currNum++;
                    currLen++;
                }
                ans = Math.max(ans, currLen);
            }
        }
        return ans;
        
    }
}