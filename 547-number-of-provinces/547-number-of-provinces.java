class Solution {
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int ans;
    int n;
    
    public int findCircleNum(int[][] isConnected) {
        ans = 0;
        n = isConnected.length;
        boolean[] visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                bfs(i, visited, isConnected);
                ans++;
            }
        }
        return ans;
    }
    
    public void bfs(int i, boolean[] visited, int[][] isConnected) {
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.addLast(i);
        while (!q.isEmpty()) {
            int node = q.removeFirst();
            int[] edges = isConnected[node];
            for (int j = 0; j < n; j++) {
                if (i != j && edges[j] == 1 && !visited[j]) {
                    q.addLast(j);
                    visited[j] = true;
                }
            }
        }
    }
}