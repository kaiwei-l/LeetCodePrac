class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> type = new HashMap<>();
        type.put(')', '(');
        type.put(']', '[');
        type.put('}', '{');
        
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (char b : s.toCharArray()) {
            if (b == '(' || b == '[' || b == '{') {
                stack.addLast(b);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char last = stack.removeLast();
                    if (type.get(b) != last) return false;
                }
            }
        }
        return (stack.size() == 0) ? true : false;
    }
}