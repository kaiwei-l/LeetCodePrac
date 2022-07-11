class Solution {
    public int wordCount(String[] startWords, String[] targetWords) {
        HashSet<String> set = new HashSet<>();
        for (String s : startWords) {
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            set.add(new String(charArr));
        }
        
        int count = 0;
        for (String s : targetWords) {
            int len = s.length();
            char[] charArr = s.toCharArray();
            Arrays.sort(charArr);
            String sortedTarget = new String(charArr);
            for (int i = 0; i < sortedTarget.length(); i++) {
                String temp = sortedTarget.substring(0, i) + sortedTarget.substring(i + 1, sortedTarget.length());
                if (set.contains(temp)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}