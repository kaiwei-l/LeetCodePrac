class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        HashMap<Character, Integer> count = new HashMap<>();
        int left = 0;
        int maxUniqueCount = 0;
        int ans = 0;
        for (int right = 0; right < n; right++) {
            Character c = s.charAt(right);
            count.put(c, count.getOrDefault(c, 0) + 1);
            maxUniqueCount = Math.max(maxUniqueCount, count.get(c));
            while (right - left + 1 > maxUniqueCount + k) {
                count.put(s.charAt(left), count.get(s.charAt(left)) - 1);
                left++;
                for (Character key : count.keySet()) {
                    maxUniqueCount = Math.max(maxUniqueCount, count.get(key));
                }
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}