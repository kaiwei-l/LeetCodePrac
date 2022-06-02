class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] ans = new int[m * n];
        int indx = 0;
        int diagonalCount = 1;
        for (int i = 0; i < n; i++) {
            ArrayList<Integer> d = new ArrayList<>();
            int row = 0;
            int col = i;
            while (row < m && col >= 0) {
                d.add(mat[row][col]);
                row++;
                col--;
            }
            if (diagonalCount % 2 != 0) {
                Collections.reverse(d);
            }
            diagonalCount++;
            for (int num : d) {
                ans[indx] = num;
                indx++;
            }
        }
        
        for (int i = 1; i < m; i++) {
            ArrayList<Integer> d = new ArrayList<>();
            int row = i;
            int col = n - 1;
            while (row < m && col >= 0) {
                d.add(mat[row][col]);
                row++;
                col--;
            }
            if (diagonalCount % 2 != 0) {
                Collections.reverse(d);
            }
            diagonalCount++;
            for (int num : d) {
                ans[indx] = num;
                indx++;
            }
        }
        return ans;
    }
}