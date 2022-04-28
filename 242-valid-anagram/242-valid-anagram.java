class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        for (int j = 0; j < t.length(); j++) {
            char c = t.charAt(j);
            if (freq.containsKey(c)) {
                freq.put(c, freq.get(c) - 1);
            } else {
                return false;
            }
        }
        
        for (Character c : freq.keySet()) {
            if (freq.get(c) != 0) return false;
        }
        return true;
    }
}