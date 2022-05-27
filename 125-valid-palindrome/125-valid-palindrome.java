class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isAlphabetic(c) || Character.isDigit(c)) str.append(Character.toLowerCase(c));
        }
        String filteredStr = str.toString();
        int left = 0;
        int right = filteredStr.length() - 1;
        while (left <= right) {
            if (filteredStr.charAt(left) != filteredStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}