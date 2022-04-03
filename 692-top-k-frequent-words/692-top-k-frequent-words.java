class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Pair<String, Integer>> maxHeap = new PriorityQueue<>((a, b) -> {
            int cmp = b.getValue() - a.getValue();
            if (cmp == 0) cmp = a.getKey().compareTo(b.getKey());
            return cmp;
        });
        HashMap<String, Integer> counter = new HashMap<>();
        for (String s : words) {
            counter.put(s, counter.getOrDefault(s, 0) + 1);
        }
        
        for (String key : counter.keySet()) {
            maxHeap.add(new Pair(key, counter.get(key)));
        }
        
        ArrayList<String> ans = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            Pair<String, Integer> p = maxHeap.poll();
            ans.add(p.getKey());
        }
        return ans;
    }
}