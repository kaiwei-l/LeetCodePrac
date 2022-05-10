class Solution {
    public int longestSubarray(int[] nums, int limit) {
        ArrayDeque<Integer> minDeque = new ArrayDeque<>();
        ArrayDeque<Integer> maxDeque = new ArrayDeque<>();
        int left = 0;
        int maxLen = 0;
        for (int right = 0; right < nums.length; right++) {
            while (!minDeque.isEmpty() && nums[right] < nums[minDeque.peekLast()]) {
                minDeque.removeLast();
            }
            while (!maxDeque.isEmpty() && nums[right] > nums[maxDeque.peekLast()]) {
                maxDeque.removeLast();
            }
            minDeque.addLast(right);
            maxDeque.addLast(right);
            while (Math.abs(nums[minDeque.peekFirst()] - nums[maxDeque.peekFirst()]) > limit) {
                left = Math.min(minDeque.peekFirst(), maxDeque.peekFirst()) + 1;
                while (minDeque.peekFirst() < left) {
                    minDeque.removeFirst();
                }
                while (maxDeque.peekFirst() < left) {
                    maxDeque.removeFirst();
                }
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
        
    }
}