class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> lastPos = new HashMap<>();
        int ans = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            Character c = s.charAt(right);
            if (!lastPos.containsKey(c)) {
                lastPos.put(c, right);
                ans = Math.max(ans, right - left + 1);
            } else {
                if (lastPos.get(c) < left) {
                    lastPos.put(c, right);
                    ans = Math.max(ans, right - left + 1);
                } else {
                    left = lastPos.get(c) + 1;
                    ans = Math.max(ans, right - left + 1);
                    lastPos.put(c, right);
                }
            }
        }
        return ans;
    }
}