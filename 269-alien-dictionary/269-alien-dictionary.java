class Solution {
    public String alienOrder(String[] words) {
        HashMap<Character, Integer> indegree = new HashMap<>();
        HashMap<Character, List<Character>> adjList = new HashMap<>();
        for (String word : words) {
            for (Character c : word.toCharArray()) {
                indegree.put(c, 0);
                adjList.put(c, new ArrayList<>());
            }
        }
        
        for (int i = 0; i < words.length - 1; i++) {
            String curr = words[i];
            String next = words[i + 1];
            if (curr.length() > next.length() && curr.startsWith(next)) {
                return "";
            }
            for (int j = 0; j < Math.min(curr.length(), next.length()); j++) {
                if (curr.charAt(j) != next.charAt(j)) {
                    indegree.put(next.charAt(j), indegree.get(next.charAt(j)) + 1);
                    adjList.get(curr.charAt(j)).add(next.charAt(j));
                    break;
                }
            }
        }
        
        StringBuilder res = new StringBuilder();
        ArrayDeque<Character> q = new ArrayDeque<>();
        for (Character node : indegree.keySet()) {
            if (indegree.get(node) == 0) {
                q.addLast(node);
            }
        }
        
        while (!q.isEmpty()) {
            Character node = q.removeFirst();
            res.append(node);
            for (Character next : adjList.get(node)) {
                indegree.put(next, indegree.get(next) - 1);
                if (indegree.get(next) == 0) q.addLast(next);
            }
        }
        
        if (res.length() != adjList.size()) return "";
        return res.toString();
    }
}