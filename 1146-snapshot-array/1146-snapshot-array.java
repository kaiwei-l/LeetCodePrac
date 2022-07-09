class SnapshotArray {
    int snapId;
    ArrayList<HashMap<Integer, Integer>> list;
    
    public SnapshotArray(int length) {
        list = new ArrayList<>();
        snapId = 0;
        for (int i = 0; i < length; i++) {
            HashMap<Integer, Integer> temp = new HashMap<>();
            temp.put(0, 0);
            list.add(temp);
        }
    }
    
    public void set(int index, int val) {
        list.get(index).put(snapId, val);
    }
    
    public int snap() {
        return snapId++;
    }
    
    public int get(int index, int snap_id) {
        for (int k = snap_id; k >= 0; k--) {
            if (list.get(index).containsKey(k)) return list.get(index).get(k);
        }
        return 0;
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */