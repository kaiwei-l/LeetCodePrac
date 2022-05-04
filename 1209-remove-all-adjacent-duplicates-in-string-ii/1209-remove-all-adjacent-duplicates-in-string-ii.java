class Solution {
    public String removeDuplicates(String s, int k) {
        Integer limit = k;
        ArrayDeque<Pair<Character, Integer>> stack = new ArrayDeque<>();
        for (Character c : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.addLast(new Pair(c, 1));
            } else {
                Pair<Character, Integer> top = stack.removeLast();
                if (c == top.getKey()) {
                    Integer freq = top.getValue();
                    stack.addLast(new Pair(c, freq + 1));
                    while (!stack.isEmpty()) {
                        Pair p = stack.removeLast();
                        if ((int)p.getValue() < k) {
                            stack.addLast(p);
                            break;
                        }
                    }
                } else {
                    stack.addLast(top);
                    stack.addLast(new Pair(c, 1));
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for (Pair<Character, Integer> p : stack) {
            int i = p.getValue();
            for (int j = 0; j < i; j++) {
                ans.append(p.getKey());
            }
        }
        return ans.toString();
    }
}