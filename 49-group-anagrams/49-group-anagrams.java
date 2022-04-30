class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sortedStr = String.valueOf(c);
            if (map.containsKey(sortedStr)) {
                map.get(sortedStr).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(sortedStr, list);
            }
        }
        
        List<List<String>> ans = new ArrayList<>();
        for (String key : map.keySet()) {
            ans.add(map.get(key));
        }
        return ans;
        
    }
}