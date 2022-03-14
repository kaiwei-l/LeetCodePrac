class Solution {
    public void cleanDeque(ArrayDeque<Integer> deq, int i, int k, int[] nums) {
        if (!deq.isEmpty() && deq.getFirst() == i - k) deq.removeFirst();
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()]) deq.removeLast(); 
    }
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;
        
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        int[] ans = new int[n - k + 1];
        int maxIndx = 0;
        for (int i = 0; i < k; i++) {
            cleanDeque(deq, i, k, nums);
            deq.addLast(i);
            
            if (nums[i] > nums[maxIndx]) maxIndx = i;
        }
        ans[0] = nums[maxIndx];
        
        for (int i = k; i < nums.length; i++) {
            cleanDeque(deq, i, k, nums);
            deq.addLast(i);
            ans[i - k + 1] = nums[deq.getFirst()];
        }
        return ans;
    }
}