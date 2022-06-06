class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] r : matrix) {
            if (binarySearch(r, 0, r.length - 1, target)) return true;
        }
        return false;
    }
    
    public boolean binarySearch(int[] arr, int left, int right, int target) {
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
}