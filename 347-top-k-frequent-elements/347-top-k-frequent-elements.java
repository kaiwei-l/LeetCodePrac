class Solution {
    HashMap<Integer, Integer> freq;
    public int[] topKFrequent(int[] nums, int k) {
        if (k == nums.length) return nums;
        freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }
        
        int[] unique = new int[freq.size()];
        int i = 0;
        for (int n : freq.keySet()) {
            unique[i] = n;
            i++;
        }
        
        int n = unique.length;
        int target = n - k;
        int pivot = quickselect(unique, 0, n - 1, target);
        return Arrays.copyOfRange(unique, pivot, n);
    }
    
    public int quickselect(int[] unique, int left, int right, int target) {
        while (left <= right) {
            int pivot = partition(unique, left, right, target);
            if (pivot == target) {
                return pivot;
            } else if (pivot < target) {
                return quickselect(unique, pivot + 1, right, target);
            } else {
                return quickselect(unique, left, pivot - 1, target);
            }
        }
        return -1;
    }
    
    public int partition(int[] unique, int left, int right, int target) {
        int pivotNum = unique[right];
        int pivot = left - 1;
        for (int i = left; i < right; i++) {
            if (freq.get(unique[i]) < freq.get(pivotNum)) {
                pivot++;
                swap(unique, pivot, i);
            }
        }
        pivot++;
        swap(unique, pivot, right);
        return pivot;
    }
    
    public void swap(int[] unique, int left, int right) {
        int temp = unique[left];
        unique[left] = unique[right];
        unique[right] = temp;
    }
}