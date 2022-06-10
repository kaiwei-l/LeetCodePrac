class Solution {
    public int longestStrChain(String[] words) {
        HashSet<String> dictionary = new HashSet<>();
        for (String w : words) {
            dictionary.add(w);
        }
        HashMap<String, Integer> memo = new HashMap<>();
        int ans = 0;
        for (String w : words) {
            ans = Math.max(ans, dfs(dictionary, memo, w));
        }
        return ans;
    }
    
    public int dfs(HashSet<String> dictionary, HashMap<String, Integer> memo, String w) {
        if (memo.containsKey(w)) return memo.get(w);
        
        int maxLen = 0;
        StringBuilder sb = new StringBuilder(w);
        for (int i = 0; i < w.length(); i++) {
            sb.deleteCharAt(i);
            String newNode = sb.toString();
            if (dictionary.contains(newNode)) {
                maxLen = Math.max(maxLen, dfs(dictionary, memo, sb.toString()));   
            }
            sb.insert(i, w.charAt(i));
        }
        maxLen++;
        memo.put(w, maxLen);
        return maxLen;
    }
}