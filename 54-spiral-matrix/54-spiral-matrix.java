class Solution {
    private int m;
    private int n;
    private int[][] directions;
    public List<Integer> spiralOrder(int[][] matrix) {
        HashSet<Pair<Integer, Integer>> visited = new HashSet<>();
        m = matrix.length;
        n = matrix[0].length;
        int dir = 0;
        directions = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        List<Integer> ans = new ArrayList<>();
        int[] point = new int[]{0, 0};
        travel(visited, point, dir, ans, matrix);
        return ans;
    }
    
    public void travel(HashSet<Pair<Integer, Integer>> visited, int[] point, int dir, List<Integer> ans, int[][] matrix) {
        if (ans.size() == m * n) return;
        int row = point[0];
        int col = point[1];
        ans.add(matrix[row][col]);
        visited.add(new Pair(row, col));
        int newRow = row + directions[dir][0];
        int newCol = col + directions[dir][1];
        if (newCol < 0 || newCol >= n || newRow < 0 || newRow >= m || visited.contains(new Pair(newRow, newCol))) {
            dir = (dir + 1) % 4;
            newRow = row + directions[dir][0];
            newCol = col + directions[dir][1];
        }
        int[] next = new int[]{newRow, newCol};
        travel(visited, next, dir, ans, matrix);
    }
}