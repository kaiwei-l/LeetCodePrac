class Solution {
    private boolean hasCycle = false;
    
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        
        for (int[] e : edges) {
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }
        
        HashSet<Integer> seen = new HashSet<>();
        ArrayDeque<Integer> s = new ArrayDeque<>();
        s.addLast(0);
        seen.add(0);
        while (!s.isEmpty()) {
            Integer curr = s.removeLast();
            for (Integer next : adjList.get(curr)) {
                if (!seen.contains(next)) {
                    seen.add(next);
                    s.addLast(next);
                }
            }
        }
        return seen.size() == n;
    }
}