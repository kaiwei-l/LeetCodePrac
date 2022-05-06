class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.addLast(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char back = stack.removeLast();
                if (back != map.get(c)) {
                    return false;
                }
            }
        }
        return (stack.isEmpty()) ? true : false;
    }
}