class Solution {
    boolean hasCycle = false;
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        HashMap<Integer, Integer> color = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.put(i, new ArrayList<Integer>());
            color.put(i, 1);
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int src = prerequisites[i][1];
            int dest = prerequisites[i][0];
            adjList.get(src).add(dest);
        }
        ArrayDeque<Integer> ans = new ArrayDeque<Integer>();
        for (int i = 0; i < numCourses; i++) {
            if (color.get(i) == 1) {
                ArrayDeque<Integer> stack = new ArrayDeque<>();
                stack.addLast(i);
                dfs(adjList, color, ans, i);
                if (hasCycle) return false;
            }
        }
        return true;
    }
    
    public void dfs(HashMap<Integer, List<Integer>> adjList, HashMap<Integer, Integer> color, ArrayDeque<Integer> ans, Integer node) {
        color.put(node, 0);
        for (Integer next : adjList.get(node)) {
            if (color.get(next) == 1) {
                color.put(next, 0);
                dfs(adjList, color, ans, next);
            } else if (color.get(next) == 0) {
                hasCycle = true;
            }
        }
        color.put(node, -1);
        ans.addFirst(node);
    }
}