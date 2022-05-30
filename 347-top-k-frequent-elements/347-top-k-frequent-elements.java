class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        PriorityQueue<Pair<Integer, Integer>> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        for (Integer num : freq.keySet()) {
            maxHeap.add(new Pair(num, freq.get(num)));
        }
        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            Pair<Integer, Integer> p = maxHeap.poll();
            ans[i] = p.getKey();
        }
        return ans;
    }
}