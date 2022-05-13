class Trie {
    HashMap<Character, Trie> map;
    List<String> list;
    
    public Trie() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }
}

class Solution {
    private HashSet<String> ans = new HashSet<>();
    
    public List<String> findWords(char[][] board, String[] words) {
        Trie root = new Trie();
        for (String s : words) {
            insert(s, root);
        }
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                backtrack(board, i, j, root, m, n);
            }
        }
        return new ArrayList<String>(ans);
    }
    
    public void backtrack(char[][] board, int i, int j, Trie root, int m, int n) {
        Trie node = root;
        Character c = board[i][j];
        board[i][j] = '1';
        if (node.map.containsKey(c)) {
            node = node.map.get(c);
            for (String w : node.list) {
                ans.add(w);
            }
            for (int rowIncre = -1; rowIncre <= 1; rowIncre++) {
                int newRow = i + rowIncre;
                if (newRow >= 0 && newRow < m && board[newRow][j] != '1') {
                    backtrack(board, newRow, j, node, m, n);
                }
            }
            
            for (int colIncre = -1; colIncre <= 1; colIncre++) {
                int newCol = j + colIncre;
                if (newCol >= 0 && newCol < n && board[i][newCol] != '1') {
                    backtrack(board, i, newCol, node, m, n);
                }
            }
        }
        board[i][j] = c;
    }
    
    public void insert(String s, Trie root) {
        Trie node = root;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (!node.map.containsKey(c)) {
                node.map.put(c, new Trie());
            }
            node = node.map.get(c);
        }
        node.list.add(s);
    }
}