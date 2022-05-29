class Trie {
    HashMap<Character, Trie> map;
    String word;
    
    public Trie() {
        map = new HashMap<>();
        word = null;
    }
}

class WordDictionary {
    private Trie root;
    
    public WordDictionary() {
        root = new Trie();
    }
    
    public void addWord(String word) {
        Trie node = root;
        for (Character c : word.toCharArray()) {
            if (!node.map.containsKey(c)) {
                node.map.put(c, new Trie());
            }
            node = node.map.get(c);
        }
        node.word = word;
    }
    
    public boolean search(String word) {
        Trie node = root;
        return searchAux(node, word, 0);
    }
    
    public boolean searchAux(Trie node, String word, int indx) {
        if (indx == word.length()) {
            return (node.word == null ? false : true);
        }
        Character c = word.charAt(indx);
        if (c == '.') {
            for (Character key : node.map.keySet()) {
                if (searchAux(node.map.get(key), word, indx + 1)) return true;
            }
        } else {
            if (!node.map.containsKey(c)) {
                return false;
            } else {
                return searchAux(node.map.get(c), word, indx + 1);
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */