class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList<>();
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        Set<String> preWords = new HashSet<>();
        
        for (String s : words) {
            if (canForm(s, preWords)) ans.add(s);
            preWords.add(s);
        }
        return ans;
    }
    
    private boolean canForm(String s, Set<String> preWords) {
        if (preWords.isEmpty()) return false;
        
        boolean[] memo = new boolean[s.length() + 1];
        memo[0] = true;
        for (int right = 1; right <= s.length(); right++) {
            for (int left = 0; left < right; left++) {
                if (memo[left] == true && preWords.contains(s.substring(left, right))) memo[right] = true;
            }
        }
        return memo[s.length()];
    }
}