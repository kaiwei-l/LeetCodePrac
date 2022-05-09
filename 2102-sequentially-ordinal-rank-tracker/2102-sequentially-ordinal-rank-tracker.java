class SORTracker {
    PriorityQueue<Pair<String, Integer>> minHeap;
    PriorityQueue<Pair<String, Integer>> maxHeap;
    int k;
    
    public SORTracker() {
        k = 0;
        minHeap = new PriorityQueue<>((a, b) -> {
            if (a.getValue().equals(b.getValue())) return b.getKey().compareTo(a.getKey());
            return a.getValue().compareTo(b.getValue());
        });
        maxHeap = new PriorityQueue<>((a, b) -> {
            if (a.getValue().equals(b.getValue())) return a.getKey().compareTo(b.getKey());
            return b.getValue().compareTo(a.getValue());
        });
    }
    
    public void add(String name, int score) {
        minHeap.add(new Pair(name, score));
        while (minHeap.size() > k + 1) {
            Pair location = minHeap.poll();
            maxHeap.add(location);
        }
    }
    
    public String get() {
        Pair<String, Integer> ans = minHeap.peek();
        k++;
        while (!maxHeap.isEmpty() && minHeap.size() < k + 1) {
            Pair location = maxHeap.poll();
            minHeap.add(location);
        }
        return ans.getKey();
    }
}

/**
 * Your SORTracker object will be instantiated and called as such:
 * SORTracker obj = new SORTracker();
 * obj.add(name,score);
 * String param_2 = obj.get();
 */