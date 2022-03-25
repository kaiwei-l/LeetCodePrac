class Trie {
    HashMap<Character, Trie> children;
    String word;
    
    public Trie() {
        this.children = new HashMap<>();
        this.word = null;
    }
}

class Solution {
    public void insert(String word, Trie node) {
        for (int i = 0; i < word.length(); i++) {
            Character currChar = word.charAt(i);
            if (!node.children.containsKey(currChar)) {
                Trie nextNode = new Trie();
                node.children.put(currChar, nextNode);
            }
            node = node.children.get(currChar);
        }
        node.word = word;
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        Trie root = new Trie();
        for (int i = 0; i < wordDict.size(); i++) {
            String currWord = wordDict.get(i);
            insert(currWord, root);
        }
        
        boolean[] wordBreak = new boolean[s.length() + 1];
        wordBreak[0] = true;
        for (int left = 0; left < s.length(); left++) {
            Trie node = root;
            for (int right = left; right < s.length(); right++) {
                Character currChar = s.charAt(right);
                if (!node.children.containsKey(currChar)) break;
                if (wordBreak[left] && node.children.get(currChar).word != null) wordBreak[right + 1] = true;
                node = node.children.get(currChar);
            }
        }
        return wordBreak[wordBreak.length - 1];
    }
}