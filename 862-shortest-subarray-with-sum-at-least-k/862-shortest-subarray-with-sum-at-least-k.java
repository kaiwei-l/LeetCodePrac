class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int minLen = n + 1;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }
        
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n + 1; i++) {
            while (!dq.isEmpty() && prefixSum[i] - prefixSum[dq.getFirst()] >= k) {
                int left = dq.removeFirst();
                minLen = Math.min(minLen, i - left);
            }
            while (!dq.isEmpty() && prefixSum[i] <= prefixSum[dq.getLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        return minLen == n + 1 ? -1 : minLen;
    }
}