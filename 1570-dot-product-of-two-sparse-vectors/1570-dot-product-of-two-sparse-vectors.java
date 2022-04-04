class SparseVector {
    HashMap<Integer, Integer> map;
    
    SparseVector(int[] nums) {
        this.map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                map.put(i, nums[i]);
            }
        }
    }
    
	// Return the dotProduct of two sparse vectors
    public int dotProduct(SparseVector vec) {
        Integer ans = 0;
        for (Integer val : this.map.keySet()) {
            if (vec.map.containsKey(val)) {
                ans += this.map.get(val) * vec.map.get(val);
            }
        }
        return ans;
    }
}

// Your SparseVector object will be instantiated and called as such:
// SparseVector v1 = new SparseVector(nums1);
// SparseVector v2 = new SparseVector(nums2);
// int ans = v1.dotProduct(v2);