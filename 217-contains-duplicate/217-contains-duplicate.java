class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        for (int n : nums) {
            counter.put(n, counter.getOrDefault(n, 0) + 1);
        }
        for (int key : counter.keySet()) {
            if (counter.get(key) > 1) return true;
        }
        return false;
    }
}