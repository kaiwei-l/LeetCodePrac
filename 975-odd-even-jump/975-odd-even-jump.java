class Solution {
    public int oddEvenJumps(int[] arr) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int ans = 1;
        int n = arr.length;
        map.put(arr[n - 1], n - 1);
        boolean[] odd = new boolean[n];
        boolean[] even = new boolean[n];
        odd[n - 1] = true;
        even[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            Integer minHigher = map.ceilingKey(arr[i]);
            Integer maxLower = map.floorKey(arr[i]);
            if (minHigher != null) {
                Integer minHigherIndx = map.get(minHigher);
                odd[i] = even[(int)minHigherIndx];
            }
            if (maxLower != null) {
                Integer maxLowerIndx = map.get(maxLower);
                even[i] = odd[(int)maxLowerIndx];
            }
            if (odd[i]) ans++;
            map.put(arr[i], i);
        }
        return ans;
    }
}