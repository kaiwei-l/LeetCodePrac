class DetectSquares {
    HashMap<Pair<Integer, Integer>, Integer> map;
    int maxRow;
    int maxCol;
    
    public DetectSquares() {
        map = new HashMap<>();
        maxRow = 0;
        maxCol = 0;
    }
    
    public void add(int[] point) {
        int r = point[1];
        int c = point[0];
        map.put(new Pair<>(r, c), map.getOrDefault(new Pair<>(r, c), 0) + 1);
        maxRow = Math.max(maxRow, r);
        maxCol = Math.max(maxCol, c);
    }
    
    public int count(int[] point) {
        int ans = 0;
        int r = point[1];
        int c = point[0];
        if (r > maxRow || c > maxCol) return ans;
        
        for (int row = 0; row <= maxRow; row++) {
            if (r != row && map.containsKey(new Pair<>(row, c))) {
                int len = Math.abs(row - r);
                ans += map.getOrDefault(new Pair<>(row, c), 0) * map.getOrDefault(new Pair<>(row, c - len), 0) * map.getOrDefault(new Pair<>(r, c - len), 0);
                ans += map.getOrDefault(new Pair<>(row, c), 0) * map.getOrDefault(new Pair<>(row, c + len), 0) * map.getOrDefault(new Pair<>(r, c + len), 0);
            }
        }
        return ans;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */