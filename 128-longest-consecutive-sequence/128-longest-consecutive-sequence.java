class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int num : nums) {
            set.add(num);
        }
        
        int maxLen = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int curr = num;
                int currLen = 1;
                
                while (set.contains(curr + 1)) {
                    curr++;
                    currLen++;
                }
                
                maxLen = Math.max(maxLen, currLen);
            }
        }
        return maxLen;
    }
}