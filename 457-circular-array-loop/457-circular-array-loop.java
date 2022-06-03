class Solution {
    public boolean circularArrayLoop(int[] nums) {
        int n = nums.length;
        if (nums == null || n == 1) return false;
        
        for (int i = 0; i < n; i++) {
            int slow = i;
            int fast = i;
            boolean isForward = (nums[slow] > 0) ? true : false;
            
            while (true) {
                slow = getNext(nums, slow, isForward);
                if (slow == -1) break;
                
                fast = getNext(nums, fast, isForward);
                if (fast == -1) break;
                fast = getNext(nums, fast, isForward);
                if (fast == -1) break;
                
                if (slow == fast) return true;
            }
        }
        return false;
    }
    
    public int getNext(int[] nums, int indx, boolean isForward) {
        boolean currDir = (nums[indx] >= 0) ? true : false;
        if (currDir != isForward) return -1;
        int n = nums.length;
        int newIndx = (indx + nums[indx]) % n;
        if (newIndx < 0) newIndx += n;
        if (newIndx == indx) return -1;
        return newIndx;
    }
}