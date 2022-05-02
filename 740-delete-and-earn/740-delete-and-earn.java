class Solution {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxNum = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num >= maxNum) maxNum = num;
            map.put(num, map.getOrDefault(num, 0) + num);
        }
        
        HashMap<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 0);
        if (map.containsKey(1)) {
            memo.put(1, map.get(1));
        } else {
            memo.put(1, 0);
        }
        return maxPoint(maxNum, memo, map);
    }
    
    public int maxPoint(Integer maxNum, HashMap<Integer, Integer> memo, HashMap<Integer, Integer> map) {
        if (!memo.containsKey(maxNum)) {
            if (map.containsKey(maxNum)) {
                Integer gain = Math.max(map.get(maxNum) + maxPoint(maxNum - 2, memo, map), maxPoint(maxNum - 1, memo, map));
                memo.put(maxNum, gain);
                return memo.get(maxNum);
            } else {
                Integer gain = Math.max(maxPoint(maxNum - 2, memo, map), maxPoint(maxNum - 1, memo, map));
                memo.put(maxNum, gain);
                return memo.get(maxNum);
            }
        } else {
            return memo.get(maxNum);
        }
    }
}