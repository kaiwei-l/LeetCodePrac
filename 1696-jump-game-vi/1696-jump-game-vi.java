class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        int[] memo = new int[n];
        memo[0] = nums[0];
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.addLast(0);
        for (int i = 1; i < n; i++) {
            while (!dq.isEmpty() && dq.getFirst() < i - k) {
                dq.removeFirst();
            }
            memo[i] = nums[i] + memo[dq.getFirst()];
            while (!dq.isEmpty() && memo[i] >= memo[dq.getLast()]) {
                dq.removeLast();
            }
            dq.addLast(i);
        }
        return memo[n - 1];
    }
}
