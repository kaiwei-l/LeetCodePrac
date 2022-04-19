class Solution {
    public boolean rotateString(String s, String goal) {
        String concat = s + s;
        if (s.length() != goal.length()) return false;
        return concat.contains(goal);
    }
}