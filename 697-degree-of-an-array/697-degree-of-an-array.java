class Solution {
    public int findShortestSubArray(int[] nums) {
        int len = nums.length + 1;
        int maxDegree = 0;
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
            maxDegree = Math.max(maxDegree, freq.get(n));
        }
        
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            int curr = nums[right];
            count.put(curr, count.getOrDefault(curr, 0) + 1);
            if (count.get(curr) == maxDegree) {
                while (left <= right && count.get(curr) == maxDegree) {
                    len = Math.min(len, right - left + 1);
                    count.put(nums[left], count.get(nums[left]) - 1);
                    left++;
                }
            }
        }
        return len;
        
    }
}