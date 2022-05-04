class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, List<Pair<String, Double>>> adjList = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String var1 = equations.get(i).get(0);
            String var2 = equations.get(i).get(1);
            Double val = values[i];
            addToGraph(adjList, var1, var2, val);
            addToGraph(adjList, var2, var1, 1.0 / val);
        }
        
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String var1 = queries.get(i).get(0);
            String var2 = queries.get(i).get(1);
            if (adjList.containsKey(var1) && adjList.containsKey(var2)) {
                if (var1.equals(var2)) {
                    ans[i] = 1.0;
                } else {
                    HashSet<String> visited = new HashSet<>();
                    visited.add(var1);
                    ArrayDeque<String> stack = new ArrayDeque<>();
                    stack.addLast(var1);
                    Double value = dfs(adjList, visited, stack, var2);
                    ans[i] = value;
                }
            } else {
                ans[i] = -1.0;
            }
        }
        return ans;
    }
    
    private Double dfs(HashMap<String, List<Pair<String, Double>>> adjList, HashSet<String> visited, ArrayDeque<String> stack, String goal) {
        while (!stack.isEmpty()) {
            String node = stack.removeLast();
            List<Pair<String, Double>> edges = adjList.get(node);
            for (Pair<String, Double> edge : edges) {
                String nextNode = edge.getKey();
                Double weight = edge.getValue();
                if (!visited.contains(nextNode)) {
                    if (goal.equals(nextNode)) {
                        return weight;
                    } else {
                        visited.add(nextNode);
                        stack.addLast(nextNode);
                        Double res = dfs(adjList, visited, stack, goal);
                        if (res != -1.0) return res * weight;
                    }
                }
            }
        }
        return -1.0;
    }
    
    private void addToGraph(HashMap<String, List<Pair<String, Double>>> adjList, String var1, String var2, Double value) {
        if (adjList.containsKey(var1)) {
            adjList.get(var1).add(new Pair(var2, value));
        } else {
            List<Pair<String, Double>> list = new ArrayList<>();
            list.add(new Pair(var2, value));
            adjList.put(var1, list);
        }
    }
}