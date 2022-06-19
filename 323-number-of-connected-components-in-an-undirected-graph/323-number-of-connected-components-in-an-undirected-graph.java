class Solution {
    public int countComponents(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        
        for (int[] e : edges) {
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }
        
        int ans = 0;
        HashSet<Integer> visited = new HashSet<>();
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (!visited.contains(i)) {
                q.addLast(i);
                bfs(visited, adjList, q);
                ans++;
            }
        }
        return ans;
    }
    
    public void bfs(HashSet<Integer> visited, HashMap<Integer, List<Integer>> adjList, ArrayDeque<Integer> q) {
        while (!q.isEmpty()) {
            Integer node = q.removeFirst();
            for (Integer next : adjList.get(node)) {
                if (!visited.contains(next)) {
                    visited.add(next);
                    q.addLast(next);
                }
            }
        }
    }
}