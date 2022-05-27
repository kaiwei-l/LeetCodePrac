class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> counter = new HashMap<>();
        for (String s : strs) {
            char[] wordArr = s.toCharArray();
            Arrays.sort(wordArr);
            String key = new String(wordArr);
            if (!counter.containsKey(key)) {
                counter.put(key, new ArrayList<String>());
            }
            counter.get(key).add(s);
        }
        List<List<String>> ans = new ArrayList<>();
        for (String key : counter.keySet()) {
            ans.add(counter.get(key));
        }
        return ans;
    }
}