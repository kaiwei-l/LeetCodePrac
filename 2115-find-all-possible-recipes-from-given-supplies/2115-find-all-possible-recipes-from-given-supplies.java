class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        HashSet<String> recipesSet = new HashSet<String>(Arrays.asList(recipes));
        HashMap<String, List<String>> adjList = new HashMap<>();
        HashMap<String, Integer> indegree = new HashMap<>();
        for (String s : supplies) {
            indegree.put(s, 0);
            adjList.put(s, new ArrayList<String>());
        }
        for (String r : recipes) {
            indegree.put(r, 0);
            adjList.put(r, new ArrayList<>());
        }
        
        for (int i = 0; i < ingredients.size(); i++) {
            String dest = recipes[i];
            for (String src : ingredients.get(i)) {
                if (!adjList.containsKey(src)) {
                    adjList.put(src, new ArrayList<String>());
                }
                adjList.get(src).add(dest);
                indegree.put(dest, indegree.getOrDefault(dest, 0) + 1);
            }
        }
        
        ArrayDeque<String> q = new ArrayDeque<>();
        List<String> ans = new ArrayList<>();
        for (String s : indegree.keySet()) {
            if (indegree.get(s) == 0) q.addLast(s);
        }
        while (!q.isEmpty()) {
            String node = q.removeFirst();
            for (String neighbor : adjList.get(node)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    q.addLast(neighbor);
                    if (recipesSet.contains(neighbor)) ans.add(neighbor);
                }
            }
        }
        return ans;
    }
}