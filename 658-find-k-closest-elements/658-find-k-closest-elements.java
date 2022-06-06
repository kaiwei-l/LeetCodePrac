class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();
        int left = 0;
        int right = arr.length - 1;
        while (right - left + 1 > k) {
            if (Math.abs(arr[left] - x) < Math.abs(arr[right] - x)) {
                right--;
            } else if (Math.abs(arr[left] - x) > Math.abs(arr[right] - x)) {
                left++;
            } else {
                if (arr[left] < arr[right]) {
                    right--;
                } else {
                    left++;
                }
            }
        }
        for (int i = left; i <= right; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }
}