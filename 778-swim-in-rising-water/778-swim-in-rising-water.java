class Solution {
    public int swimInWater(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        HashSet<Pair<Integer, Integer>> visited = new HashSet<>();
        PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>((p1, p2) -> {
            return grid[p1.getKey()][p1.getValue()] - grid[p2.getKey()][p2.getValue()];
        });
        int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        visited.add(new Pair(0, 0));
        minHeap.add(new Pair(0, 0));
        while (!minHeap.isEmpty()) {
            Pair<Integer, Integer> p = minHeap.poll();
            int r = p.getKey();
            int c = p.getValue();
            ans = Math.max(ans, grid[r][c]);
            if (r == n - 1 && c == n - 1) return ans;
            for (int[] dir : directions) {
                int newRow = r + dir[0];
                int newCol = c + dir[1];
                Pair<Integer, Integer> next = new Pair<>(newRow, newCol);
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && !visited.contains(next)) {
                    visited.add(next);
                    minHeap.add(next);
                }
            }
        }
        
        return ans;
    }
}