class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, HashMap<String, Double>> adjList = new HashMap<>();
        
        for (int i = 0; i < equations.size(); i++) {
            List<String> equation = equations.get(i);
            String a = equation.get(0);
            String b = equation.get(1);
            Double value = values[i];
            Double revValue = 1/value;
            HashMap<String, Double> edgesOfA = adjList.getOrDefault(a, new HashMap<String, Double>());
            edgesOfA.put(b, value);
            adjList.put(a, edgesOfA);
            HashMap<String, Double> edgesOfB = adjList.getOrDefault(b, new HashMap<String, Double>());
            edgesOfB.put(a, revValue);
            adjList.put(b, edgesOfB);
        }
        
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> q = queries.get(i);
            String a = q.get(0);
            String b = q.get(1);
            if (!adjList.containsKey(a) || !adjList.containsKey(b)) {
                ans[i] = -1.0;
            } else if (a.equals(b)) {
                ans[i] = 1.0;
            } else {
                HashMap<String, Boolean> visited = new HashMap<>();
                ArrayDeque<String> stack = new ArrayDeque<>();
                stack.addLast(a);
                visited.put(a, true);
                Pair<Boolean, Double> p = dfs(adjList, visited, b, stack);
                ans[i] = p.getValue();
            }
        }
        
        return ans;
        
    }
    
    public Pair<Boolean, Double> dfs(HashMap<String, HashMap<String, Double>> adjList, HashMap<String, Boolean> visited, String target, ArrayDeque<String> stack) {
        while (!stack.isEmpty()) {
            String var = stack.removeLast();
            HashMap<String, Double> adjEdges = adjList.get(var);
            for (String node : adjEdges.keySet()) {
                if (!visited.containsKey(node)) {
                    visited.put(node, true);
                    if (node.equals(target)) {
                        Pair<Boolean, Double> p = new Pair<>(true, adjEdges.get(node));
                        return p;
                    } else {
                        stack.addLast(node);
                        Pair<Boolean, Double> p = dfs(adjList, visited, target, stack);
                        if (p.getKey()) {
                            Double tempVal = p.getValue();
                            tempVal *= adjEdges.get(node);
                            return new Pair<Boolean, Double>(true, tempVal);
                        }
                    }
                }
            }
        }
        return new Pair<Boolean, Double>(false, -1.0);
    }
}