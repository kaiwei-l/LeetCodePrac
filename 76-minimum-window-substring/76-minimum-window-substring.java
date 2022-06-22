class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        HashMap<Character, Integer> countT = new HashMap<>();
        for (Character c : t.toCharArray()) {
            countT.put(c, countT.getOrDefault(c, 0) + 1);
        }
        int uniqueCount = countT.size();
        HashMap<Character, Integer> countS = new HashMap<>();
        int minLeft = 0;
        int minRight = 0;
        int len = s.length() + 1;
        int left = 0;
        int currCount = 0;
        for (int right = 0; right < s.length(); right++) {
            Character c = s.charAt(right);
            countS.put(c, countS.getOrDefault(c, 0) + 1);
            if (countT.containsKey(c) && countT.get(c).equals(countS.get(c))) currCount++;
            while (left <= right && currCount == uniqueCount) {
                if (right - left + 1 < len) {
                    len = right - left + 1;
                    minLeft = left;
                    minRight = right;
                }
                Character leftC = s.charAt(left);
                countS.put(leftC, countS.get(leftC) - 1);
                if (countT.containsKey(leftC) && countS.get(leftC).compareTo(countT.get(leftC)) < 0) {
                    currCount--;
                }
                left++;
            }
        }
        return (len == s.length() + 1) ? "" : s.substring(minLeft, minRight + 1);
    }
}