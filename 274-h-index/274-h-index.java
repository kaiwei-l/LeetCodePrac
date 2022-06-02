class Solution {
    public int hIndex(int[] citations) {
        int[] counting = new int[1001];
        for (int c : citations) {
            counting[c]++;
        }
        
        for (int i = 999; i >= 0; i--) {
            counting[i] += counting[i + 1];
        }
        
        for (int h = 1000; h >= 0; h--) {
            if (counting[h] >= h) {
                return h;
            }
        }
        return -1;
    }
}