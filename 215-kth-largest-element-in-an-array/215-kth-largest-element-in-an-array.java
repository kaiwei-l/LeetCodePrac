class Solution {
    int[] nums;
    
    public void swap (int a, int b) {
        int temp = this.nums[a];
        this.nums[a] = this.nums[b];
        this.nums[b] = temp;
    }
    
    public int partition(int left, int right, int pivotIndx) {
        int pivot = this.nums[pivotIndx];
        
        swap(pivotIndx, right);
        
        int storeIndx = left;
        for (int i = left; i < right; i++) {
            if (this.nums[i] < pivot) {
                swap(i, storeIndx);
                storeIndx++;
            }
        }
        
        swap(right, storeIndx);        
        return storeIndx;
    }
    
    public int quickSelect(int left, int right, int kSmallest) {
        if (left == right) return this.nums[left];
        
        int pivotIndx = left;
        
        pivotIndx = partition(left, right, pivotIndx);
        
        if (pivotIndx == kSmallest) {
            return this.nums[pivotIndx];
        } else if (pivotIndx > kSmallest) {
            return quickSelect(left, pivotIndx - 1, kSmallest);
        } else {
            return quickSelect(pivotIndx + 1, right, kSmallest);
        }
    }
    
    public int findKthLargest(int[] nums, int k) {
        this.nums = nums;
        int n = nums.length;
        return quickSelect(0, n - 1, n - k);
    }
}