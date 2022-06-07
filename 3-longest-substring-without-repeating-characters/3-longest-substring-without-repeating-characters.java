class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> lastIndx = new HashMap<>();
        int left = 0;
        int ans = 0;
        for (int right = 0; right < s.length(); right++) {
            Character c = s.charAt(right);
            if (lastIndx.containsKey(c)) {
                if (left <= lastIndx.get(c)) {
                    left = lastIndx.get(c);
                    left++;
                    ans = Math.max(ans, right - left + 1);
                } else {
                    ans = Math.max(ans, right - left + 1);
                }
                lastIndx.put(c, right);
            } else {
                ans = Math.max(ans, right - left + 1);
                lastIndx.put(c, right);
            }
        }
        return ans;
    }
}