class Solution {
    public int[][] highFive(int[][] items) {
        HashMap<Integer, ArrayList<Integer>> dict = new HashMap<>();
        for (int i = 0; i < items.length; i++) {
            Integer id = items[i][0];
            Integer score = items[i][1];
            ArrayList<Integer> scores = dict.getOrDefault(id, new ArrayList<Integer>());
            scores.add(score);
            dict.put(id, scores);
        }
        int[][] ans = new int[dict.size()][2];
        int indx = 0;
        for (Integer id : dict.keySet()) {
            ArrayList<Integer> scores = dict.get(id);
            scores.sort((Integer a, Integer b) -> b - a);
            int sum = 0;
            for (int i = 0; i < 5; i++) {
                sum += scores.get(i);
            }
            ans[indx][0] = id;
            ans[indx][1] = sum / 5;
            indx++;
        }
        return ans;
    }
}