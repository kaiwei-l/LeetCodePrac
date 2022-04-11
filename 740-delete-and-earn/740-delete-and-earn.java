class Solution {
    HashMap<Integer, Integer> points = new HashMap<>();
    HashMap<Integer, Integer> cache = new HashMap<>();
    
    public int dp(int num) {
        if (num == 0) return 0;
        
        if (num == 1) return points.getOrDefault(1, 0);
        
        if (cache.containsKey(num)) return cache.get(num);
        
        int gain = points.getOrDefault(num, 0);
        int profit = Math.max(gain + dp(num - 2), dp(num - 1));
        cache.put(num, profit);
        return cache.get(num);
    }
    
    public int deleteAndEarn(int[] nums) {
        int maxNum = nums[0];
        for (int num : nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNum = Math.max(maxNum, num);
        }
        return dp(maxNum);
    }
}