class Solution {
    List<List<Integer>> ans;
    
    public List<List<Integer>> permute(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        ans = new ArrayList<>();
        for (int num : nums) {
            freq.put(num, 1);
        }
        for (Integer key : freq.keySet()) {
            freq.put(key, 0);
            List<Integer> curr = new ArrayList<Integer>();
            curr.add(key);
            backtrack(freq, curr, nums.length);
            freq.put(key, 1);
            curr.remove(curr.size() - 1);
        }
        return ans;
    }
    
    public void backtrack(HashMap<Integer, Integer> freq, List<Integer> curr, int goal) {
        if (curr.size() == goal) {
            List<Integer> res = new ArrayList<>(curr);
            ans.add(res);
            return;
        } else {
            for (Integer key : freq.keySet()) {
                if (freq.get(key) == 1) {
                    curr.add(key);
                    freq.put(key, 0);
                    backtrack(freq, curr, goal);
                    curr.remove(curr.size() - 1);
                    freq.put(key, 1);
                }
            }
        }
    }
}