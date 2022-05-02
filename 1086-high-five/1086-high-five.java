class Solution {
    public int[][] highFive(int[][] items) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int i = 0; i < items.length; i++) {
            int[] tuple = items[i];
            int id = tuple[0];
            int score = tuple[1];
            PriorityQueue<Integer> q = map.getOrDefault(id, new PriorityQueue<Integer>((a, b) -> a - b));
            q.add(score);
            if (q.size() > 5) {
                q.poll();
            }
            map.put(id, q);
        }
        int[][] ans = new int[map.size()][2];
        int indx = 0;
        for (int id : map.keySet()) {
            PriorityQueue<Integer> q = map.get(id);
            int sum = 0;
            while (!q.isEmpty()) {
                sum += q.poll();
            }
            ans[indx][0] = id;
            ans[indx][1] = sum / 5;
            indx++;
        }
        Arrays.sort(ans, (a, b) -> Integer.compare(a[0], b[0]));
        return ans;
    }
}