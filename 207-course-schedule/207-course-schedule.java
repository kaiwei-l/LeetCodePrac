class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        HashMap<Integer, Integer> indegree = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.put(i, new ArrayList<Integer>());
            indegree.put(i, 0);
        }
        for (int[] edge : prerequisites) {
            int src = edge[1];
            int dest = edge[0];
            adjList.get(src).add(dest);
            indegree.put(dest, indegree.get(dest) + 1);
        }
        
        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (Integer node : indegree.keySet()) {
            if (indegree.get(node) == 0) q.addLast(node);
        }
        
        while (!q.isEmpty()) {
            Integer node = q.removeFirst();
            for (Integer next : adjList.get(node)) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) q.addLast(next);
            }
        }
        
        for (Integer node : indegree.keySet()) {
            if (indegree.get(node) != 0) return false;
        }
        return true;
    }
}