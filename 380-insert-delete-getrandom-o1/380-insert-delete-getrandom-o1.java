class RandomizedSet {
    Random rand = new Random();
    HashMap<Integer, Integer> map;
    ArrayList<Integer> list;
    
    public RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        int s = list.size();
        list.add(val);
        map.put(val, s);
        return true;
    }
    
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int indxOfVal = map.get(val);
        int lastIndx = list.size() - 1;
        map.put(list.get(lastIndx), indxOfVal);
        list.set(indxOfVal, list.get(lastIndx));
        list.remove(lastIndx);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */