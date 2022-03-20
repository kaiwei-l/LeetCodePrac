class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            count.put(arr[i], count.getOrDefault(arr[i], 0) + 1);
        }
        PriorityQueue<Pair<Integer, Integer>> q = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        for (Integer num : count.keySet()) {
            q.add(new Pair<Integer, Integer>(num, count.get(num)));
        }
        for (int i = 0; i < k; i++) {
            Pair<Integer, Integer> pair = q.poll();
            Integer frequency = pair.getValue();
            Integer key = pair.getKey();
            if (--frequency != 0) q.add(new Pair<Integer, Integer>(key, frequency));
        }
        return q.size();
    }
}