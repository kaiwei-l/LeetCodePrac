class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        if (s.length() == 0 || t.length() == 0) return "";
        
        HashMap<Character, Integer> tCount = new HashMap<>();
        for (Character c : t.toCharArray()) {
            tCount.put(c, tCount.getOrDefault(c, 0) + 1);
        }
        
        int need = tCount.size();
        int formed = 0;
        int ans = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int left = 0;
        HashMap<Character, Integer> window = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            Character c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (tCount.containsKey(c) && tCount.get(c).equals(window.get(c))) formed++;
            while (formed == need && left <= right) {
                if (ans > right - left + 1) {
                    ans = right - left + 1;
                    start = left;
                    end = right;
                }
                c = s.charAt(left);
                window.put(c, window.get(c) - 1);
                left++;
                if (tCount.containsKey(c) && tCount.get(c).intValue() > window.get(c).intValue()) formed--;
            }
        }
        return (ans == Integer.MAX_VALUE) ? "" : s.substring(start, end + 1);
    }
}