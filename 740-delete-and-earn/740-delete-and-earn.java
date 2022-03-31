class Solution {
    public int deleteAndEarn(int[] nums) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        int maxNum = 0;
        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i];
            counter.put(currNum, counter.getOrDefault(currNum, 0) + currNum);
            maxNum = Math.max(maxNum, currNum);
        }
        
        int[] maxPoint = new int[maxNum + 1];
        maxPoint[0] = 0;
        maxPoint[1] = counter.getOrDefault(1, 0);
        for (int i = 2; i < maxNum + 1; i++) {
            maxPoint[i] = Math.max(maxPoint[i - 1], maxPoint[i - 2] + counter.getOrDefault(i, 0));
        }
        return maxPoint[maxNum];
    }
}