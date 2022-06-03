class Solution {
    int m;
    int n;
    
    public boolean removeOnes(int[][] grid) {
        if (grid == null || grid.length == 0) return false;
        
        for (int i = 0; i < grid.length; i++) {
            if (!equalOrOpposite(grid[0], grid[i])) return false;
        }
        return true;
    }
    
    public boolean equalOrOpposite(int[] first, int[] second) {
        int numDifferent = 0;
        for (int i = 0; i < first.length; ++i) {
            if (first[i] != second[i]) numDifferent++;
        }
        return numDifferent == 0 || numDifferent == first.length;
    }
}