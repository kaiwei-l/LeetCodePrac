class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permute(int[] nums) {
        ans = new ArrayList<>();
        ArrayList<Integer> p = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, 1);
        }
        backtrack(nums, p, 0, map);
        return ans;
    }
    
    public void backtrack(int[] nums, ArrayList<Integer> p, int start, HashMap<Integer, Integer> map) {
        if (start == nums.length) {
            ans.add(new ArrayList<Integer>(p));
            return;
        }
        for (int num : map.keySet()) {
            if (map.get(num) == 1) {
                map.put(num, 0);
                p.add(num);
                backtrack(nums, p, start + 1, map);
                map.put(num, 1);
                p.remove(p.size() - 1);
            }
        }
    }
}