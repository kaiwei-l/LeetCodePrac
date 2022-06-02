class Solution {
    int m;
    int n;
    
    public boolean searchMatrix(int[][] matrix, int target) {
        m = matrix.length;
        n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            Pair<Integer, Integer> point = numToPoint(mid);
            int row = point.getKey();
            int col = point.getValue();
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }
    
    public Pair<Integer, Integer> numToPoint(int num) {
        int row = num / n;
        int col = num % n;
        return new Pair(row, col);
    }
}