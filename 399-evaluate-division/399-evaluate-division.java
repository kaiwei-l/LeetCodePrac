class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, ArrayList<Pair<String, Double>>> adjList = new HashMap<String, ArrayList<Pair<String, Double>>>();
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            Double value = values[i];
            String var1 = equation.get(0);
            String var2 = equation.get(1);
            ArrayList<Pair<String, Double>> edges1 = adjList.getOrDefault(var1, new ArrayList<Pair<String, Double>>());
            ArrayList<Pair<String, Double>> edges2 = adjList.getOrDefault(var2, new ArrayList<Pair<String, Double>>());
            edges1.add(new Pair(var2, value));
            edges2.add(new Pair(var1, 1 / value));
            adjList.put(var1, edges1);
            adjList.put(var2, edges2);
        }
        
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> q = queries.get(i);
            String var1 = q.get(0);
            String var2 = q.get(1);
            if (adjList.containsKey(var1)) {
                HashMap<String, Boolean> visited = new HashMap<>();
                visited.put(var1, true);
                ArrayDeque<String> stack = new ArrayDeque<>();
                stack.add(var1);
                Double res = dfs(adjList, stack, visited, var2);
                ans[i] = res;
            } else {
                ans[i] = -1.0;
            }
        }
        return ans;
    }
    
    public double dfs(HashMap<String, ArrayList<Pair<String, Double>>> adjList, ArrayDeque<String> stack, HashMap<String, Boolean> visited, String goal) {
        while (!stack.isEmpty()) {
            String node = stack.removeLast();
            ArrayList<Pair<String, Double>> edges = adjList.get(node);
            for (Pair<String, Double> p : edges) {
                String nextNode = p.getKey();
                if (nextNode.equals(goal)) {
                    return p.getValue();
                } else {
                    if (!visited.containsKey(nextNode) || !visited.get(nextNode)) {
                        visited.put(nextNode, true);
                        stack.addLast(nextNode);
                        double ans = dfs(adjList, stack, visited, goal);
                        if (ans != -1.0) {
                            return ans * p.getValue();
                        }
                    }   
                }
            }
        }
        return -1;
    }
}