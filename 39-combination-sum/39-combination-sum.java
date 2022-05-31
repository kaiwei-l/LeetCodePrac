class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<List<Integer>>> memo = new ArrayList<>();
        for (int i = 0; i <= target; i++) {
            memo.add(new ArrayList<>());
        }
        memo.get(0).add(new ArrayList<>());
        for (int c : candidates) {
            for (int i = c; i <= target; i++) {
                List<List<Integer>> temp = memo.get(i - c);
                for (List<Integer> combo : temp) {
                    List<Integer> newCombo = new ArrayList<>(combo);
                    newCombo.add(c);
                    memo.get(i).add(newCombo);
                }
            }
        }
        return memo.get(target);
    }
}