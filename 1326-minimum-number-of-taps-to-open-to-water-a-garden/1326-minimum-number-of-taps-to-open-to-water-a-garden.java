class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] arr = new int[n + 1];
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i] != 0) {
                int left = Math.max(0, i - ranges[i]);
                arr[left] = Math.max(arr[left], i + ranges[i]);
            }
        }
        
        int count = 0;
        int currentWaterEnd = 0;
        int farestCanWater = 0;
        int i = 0;
        while (i < arr.length && currentWaterEnd < n) {
            count++;
            while (i < arr.length && i <= currentWaterEnd) {
                farestCanWater = Math.max(farestCanWater, arr[i]);
                i++;
            }
            if (currentWaterEnd == farestCanWater) return -1;
            currentWaterEnd = farestCanWater;
        }
        return count;
    }
}