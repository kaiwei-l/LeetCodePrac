class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        combinationAux(candidates, target, new ArrayList<Integer>(), 0);
        return ans;
    }
    
    public void combinationAux(int[] candidates, int target, ArrayList<Integer> curr, int indx) {
        if (target < 0) return;
        
        if (target == 0) {
            List<Integer> res = new ArrayList<>(curr);
            ans.add(res);
            return;
        }
        
        for (int i = indx; i < candidates.length; i++) {
            curr.add(candidates[i]);
            combinationAux(candidates, target - candidates[i], curr, i);
            curr.remove(curr.size() - 1);
        }
    }
}