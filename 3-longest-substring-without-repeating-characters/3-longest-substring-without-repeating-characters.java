class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int maxLen = Integer.MIN_VALUE;
        int currLen = 0;
        int left = 0;
        HashMap<Character, Integer> freq = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            Character c = s.charAt(right);
            if (!freq.containsKey(c) || freq.get(c) == 0) {
                freq.put(c, freq.getOrDefault(c, 0) + 1);
                currLen++;
                maxLen = Math.max(maxLen, currLen);
            } else {
                freq.put(c, freq.get(c) + 1);
                currLen++;
                while (freq.get(c) > 1 && left <= right) {
                    Character leftC = s.charAt(left);
                    freq.put(leftC, freq.get(leftC) - 1);
                    left++;
                    currLen--;
                }
            }
        }
        return maxLen;
    }
}