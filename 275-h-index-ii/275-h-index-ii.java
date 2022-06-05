class Solution {
    public int hIndex(int[] citations) {
        int ans = Integer.MIN_VALUE;
        int n = citations.length;
        int left = 0;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int paperMid = n - mid;
            if (citations[mid] == paperMid) {
                return citations[mid];
            } else if (citations[mid] > paperMid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return n - left;
    }
}