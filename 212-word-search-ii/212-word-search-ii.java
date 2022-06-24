class Trie {
    String word;
    HashMap<Character, Trie> map;
    
    public Trie() {
        word = null;
        map = new HashMap<>();
    }
}

class Solution {
    Trie root;
    List<String> ans;
    int m;
    int n;
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public List<String> findWords(char[][] board, String[] words) {
        root = new Trie();
        ans = new ArrayList<>();
        for (String w : words) {
            insert(root, w);
        }
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (root.map.containsKey(board[i][j])) search(board, i, j, root.map.get(board[i][j]));
            }
        }
        return ans;
    }
    
    public void search(char[][] board, int row, int col, Trie root) {
        if (root.word != null) {
            ans.add(root.word);
            root.word = null;
        }
        
        Character c = board[row][col];
        board[row][col] = '1';
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && root.map.containsKey(board[newRow][newCol])) {
                search(board, newRow, newCol, root.map.get(board[newRow][newCol]));
            }
        }
        board[row][col] = c;
    }
    
    public void insert(Trie root, String w) {
        for (Character c : w.toCharArray()) {
            if (!root.map.containsKey(c)) {
                root.map.put(c, new Trie());
            }
            root = root.map.get(c);
        }
        root.word = w;
    }
}