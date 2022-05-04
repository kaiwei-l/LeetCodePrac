class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        PriorityQueue<Pair<String, Integer>> freq = new PriorityQueue<>((a, b) -> {
            if (a.getValue() == b.getValue()) return b.getKey().compareTo(a.getKey());
            return a.getValue() - b.getValue();
        });
        
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (String key : map.keySet()) {
            freq.add(new Pair(key, map.get(key)));
            if (freq.size() > k) freq.poll();
        }
        List<String> list = new ArrayList<>();
        while (freq.size() != 0) {
            list.add(freq.poll().getKey());
        }
        Collections.reverse(list);
        return list;
    }
}