class Trie {
    HashMap<Character, Trie> map;
    List<String> suggestions;
    
    public Trie() {
        map = new HashMap<>();
        suggestions = new ArrayList<>();
    }
}

class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie root = new Trie();
        for (String p : products) {
            insert(p, root);
        }
        
        List<List<String>> ans = new ArrayList<>();
        search(searchWord, root, ans);
        return ans;
    }
    
    public void insert(String s, Trie root) {
        Trie node = root;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (!node.map.containsKey(c)) node.map.put(c, new Trie());
            node = node.map.get(c);
            node.suggestions.add(s);
            Collections.sort(node.suggestions);
            if (node.suggestions.size() > 3) node.suggestions.remove(3);
        }
    }
    
    public void search(String s, Trie root, List<List<String>> ans) {
        Trie node = root;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (node != null) node = node.map.get(c);
            ans.add((node == null) ? new ArrayList<String>() : node.suggestions);
        }
    }
}