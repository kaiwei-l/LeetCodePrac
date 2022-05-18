class Solution {
    int m;
    int n;
    int[][] directions;
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;
        directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        ArrayDeque<Pair<Integer, Integer>> pacificQ = new ArrayDeque<>();
        ArrayDeque<Pair<Integer, Integer>> atlanticQ = new ArrayDeque<>();
        
        for (int i = 0; i < m; i++) {
            pacificQ.addLast(new Pair(i, 0));
            atlanticQ.addLast(new Pair(i, n - 1));
        }
        for (int i = 0; i < n; i++) {
            pacificQ.addLast(new Pair(0, i));
            atlanticQ.addLast(new Pair(m - 1, i));
        }
        
        boolean[][] canGetPacific = bfs(pacificQ, heights);
        boolean[][] canGetAtlantic = bfs(atlanticQ, heights);
        
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canGetPacific[i][j] && canGetAtlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }
    
    public boolean[][] bfs(ArrayDeque<Pair<Integer, Integer>> q, int[][] heights) {
        boolean[][] canGetOcean = new boolean[m][n];
        while (!q.isEmpty()) {
            Pair<Integer, Integer> node = q.removeFirst();
            int row = node.getKey();
            int col = node.getValue();
            canGetOcean[row][col] = true;
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {
                    if (!canGetOcean[newRow][newCol]) {
                        if (heights[newRow][newCol] >= heights[row][col]) {
                            q.addLast(new Pair(newRow, newCol));
                        }
                    }
                }
            }
        }
        return canGetOcean;
    }
}