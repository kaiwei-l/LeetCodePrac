class Node {
    public HashMap<Character, Node> dict;
    public HashMap<String, Integer> hotSentences;
    
    public Node() {
        this.dict = new HashMap<>();
        this.hotSentences = new HashMap<String, Integer>();
    }
}

class AutocompleteSystem {
    public Node root = new Node();
    public String prefix = "";
    
    public void insert(String sentence, int time) {
        Node trie = this.root;
        for (int i = 0; i < sentence.length(); i++) {
            char c = sentence.charAt(i);
            if (!trie.dict.containsKey(c)) {
                trie.dict.put(Character.valueOf(c), new Node());
            }
            trie = trie.dict.get(c);
            trie.hotSentences.put(sentence, trie.hotSentences.getOrDefault(sentence, 0) + time);
        }
    }

    public AutocompleteSystem(String[] sentences, int[] times) {
        for (int i = 0; i < sentences.length; i++) {
            String sentence = sentences[i];
            int time = times[i];
            this.insert(sentence, time);
        }
    }
    
    public List<String> input(char c) {
        if (c == '#') {
            insert(this.prefix, 1);
            this.prefix = "";
            return new ArrayList<String>();
        }
        this.prefix += c;
        Node curr = this.root;
        for (int i = 0; i < this.prefix.length(); i++) {
            char currChar = this.prefix.charAt(i);
            Node next = curr.dict.get(currChar);
            if (next == null) {
                return new ArrayList<String>();
            }
            curr = next;
        }
        
        ArrayList<Pair<String, Integer>> hotCount = new ArrayList<>();
        for (String key : curr.hotSentences.keySet()) {
            hotCount.add(new Pair(key, curr.hotSentences.get(key)));
        }
        hotCount.sort((a, b) -> a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < hotCount.size(); i++) {
            if (ans.size() < 3) {
                ans.add(hotCount.get(i).getKey());
            } else {
                break;
            }
        }
        return ans;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */