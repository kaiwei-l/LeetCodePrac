class Solution {
    int[] list;
    int totalSum;
    
    public Solution(int[] w) {
        list = new int[w.length];
        totalSum = 0;
        for (int i = 0; i < w.length; i++) {
            totalSum += w[i];
            list[i] = totalSum;
        }
    }
    
    public int pickIndex() {
        int target = (int)(Math.random() * totalSum);
        for (int i = 0; i < list.length; i++) {
            if (list[i] > target) return i;
        }
        return list.length - 1;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */