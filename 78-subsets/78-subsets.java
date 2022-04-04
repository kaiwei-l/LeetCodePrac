class Solution {
    List<List<Integer>> output = new ArrayList();
    
    public List<List<Integer>> subsets(int[] nums) {
        for (int k = 0; k < nums.length + 1; k++) {
            backtrack(0, new ArrayList(), nums, k);
        }
        return output;
    }
    
    public void backtrack(int first, ArrayList<Integer> curr, int[] nums, int k) {
        if (curr.size() == k) {
            output.add(new ArrayList(curr));
            return;
        }
        for (int i = first; i < nums.length; i++) {
            curr.add(nums[i]);
            backtrack(i + 1, curr, nums, k);
            curr.remove(curr.size() - 1);
        }
    }
}