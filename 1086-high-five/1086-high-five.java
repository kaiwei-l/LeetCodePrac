class Solution {
    public int[][] highFive(int[][] items) {
        HashMap<Integer, List<Integer>> counter = new HashMap<>();
        for (int i = 0; i < items.length; i++) {
            int id = items[i][0];
            int score = items[i][1];
            List<Integer> scores = counter.getOrDefault(id, new ArrayList<Integer>());
            scores.add(score);
            counter.put(id, scores);
        }
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int id : counter.keySet()) {
            List<Integer> scoresList = counter.get(id);
            scoresList.sort((a, b) -> b - a);
            int topScoreSum = 0;
            for (int i = 0; i < 5; i++) {
                topScoreSum += scoresList.get(i);
            }
            int avgScore = topScoreSum / 5;
            List<Integer> student = new ArrayList<Integer>();
            student.add(id);
            student.add(avgScore);
            ans.add(student);
        }
        ans.sort((a, b) -> a.get(0) - b.get(0));
        int[][] res = new int[ans.size()][2];
        for (int i = 0; i < ans.size(); i++) {
            List<Integer> s = ans.get(i);
            res[i][0] = s.get(0);
            res[i][1] = s.get(1);
        }
        return res;
        
    }
}