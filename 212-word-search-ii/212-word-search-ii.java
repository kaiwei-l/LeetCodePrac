class Trie {
    HashMap<Character, Trie> map;
    String word;
    
    public Trie() {
        this.map = new HashMap<>();
        this.word = null;
    }
}
class Solution {
    int[][] directions = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    Trie root;
    int m;
    int n;
    HashSet<Pair<Integer, Integer>> visited;
    List<String> ans;
    
    public List<String> findWords(char[][] board, String[] words) {
        ans = new ArrayList<>();
        root = new Trie();
        m = board.length;
        n = board[0].length;
        
        for (String w : words) {
            insert(root, w);
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (root.map.containsKey(board[i][j])) {
                    visited = new HashSet<>();
                    visited.add(new Pair(i, j));
                    search(new Pair(i, j), root, board);
                }
            }
        }
        return ans;
    }
    
    public void search(Pair<Integer, Integer> point, Trie parent, char[][] board) {
        int row = point.getKey();
        int col = point.getValue();
        char c = board[row][col];
        Trie node = parent.map.get(c);
        if (node.word != null) {
            ans.add(node.word);
            node.word = null;
        }
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            Pair<Integer, Integer> next = new Pair(newRow, newCol);
            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited.contains(next) && node.map.containsKey(board[newRow][newCol])) {
                visited.add(next);
                search(next, node, board);
            }
        }
        visited.remove(point);
        //if (node.map.size() == 0) parent.map.remove(c);
    }
    
    public void insert(Trie root, String word) {
        Trie node = root;
        for (Character c : word.toCharArray()) {
            if (!node.map.containsKey(c)) {
                node.map.put(c, new Trie());
            }
            node = node.map.get(c);
        }
        node.word = word;
    }
}