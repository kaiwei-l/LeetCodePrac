class Trie {
    private HashMap<Character, Trie> map;
    private String word;
    
    public Trie() {
        this.map = new HashMap<>();
        this.word = null;
    }
    
    public void insert(String word) {
        Trie node = this;
        for (Character c : word.toCharArray()) {
            if (!node.map.containsKey(c)) {
                node.map.put(c, new Trie());
            }
            node = node.map.get(c);
        }
        node.word = word;
    }
    
    public boolean search(String word) {
        Trie node = this;
        for (Character c : word.toCharArray()) {
            if (node.map.containsKey(c)) {
                node = node.map.get(c);
            } else {
                return false;
            }
        }
        return ((node.word == null) ? false : true);
    }
    
    public boolean startsWith(String prefix) {
        Trie node = this;
        for (Character c : prefix.toCharArray()) {
            if (node.map.containsKey(c)) {
                node = node.map.get(c);
            } else {
                return false;
            }
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */