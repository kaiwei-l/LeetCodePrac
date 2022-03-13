class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            int[] ans = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                ans[i] = i;
            }
            return ans;
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] hasTopNum = new boolean[numCourses];
        int topNum = numCourses - 1;
        int[] topList = new int[numCourses];
        Arrays.fill(topList, -1);
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        
        for (int i = 0; i < prerequisites.length; i++) {
            int[] edge = prerequisites[i];
            List<Integer> neighbors;
            if (!adjList.containsKey(edge[1])) {
                neighbors = new ArrayList<>();
                neighbors.add(edge[0]);
                adjList.put(edge[1], neighbors);
            } else {
                neighbors = adjList.get(edge[1]);
                neighbors.add(edge[0]);
                adjList.put(edge[1], neighbors);
            }
        }
        
        for (int i = 0; i < prerequisites.length; i++) {
            int[] edge = prerequisites[i];
            int node = edge[1];
            if (!visited[node]) {
                topNum = dfs(adjList, topList, visited, node, topNum, hasTopNum);
                if (topNum == -2) return new int[0];
            }
        }
        for (int i = 0; i < visited.length; i++) {
        	if (visited[i] == false) {
        		topList[topNum] = i;
        		topNum--;
        	}
        }
        return topList;
    }
    
    public int dfs(HashMap<Integer, List<Integer>> adjList, int[] topList, boolean[] visited, int node, int topNum, boolean[] hasTopNum) {
        visited[node] = true;
        List<Integer> neighbors = adjList.get(node);
        if (neighbors != null) {
            for (int i = 0; i < neighbors.size(); i++) {
                int neighbor = neighbors.get(i);
                if (!visited[neighbor]) {
                    topNum = dfs(adjList, topList, visited, neighbor, topNum, hasTopNum);
                } else {
                    if (hasTopNum[neighbor] == false) return -2;
                }
            }
        }
        if (topNum == -2) return -2;
        topList[topNum] = node;
        hasTopNum[node] = true;
        return --topNum;
    }
}