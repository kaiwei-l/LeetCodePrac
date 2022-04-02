class Solution {
    public String removeDuplicates(String s, int k) {
        ArrayDeque<Pair<Character, Integer>> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.size() == 0 || stack.getLast().getKey() != s.charAt(i)) {
                stack.addLast(new Pair<Character, Integer>(s.charAt(i), 1));
            } else {
                Pair<Character, Integer> p = stack.removeLast();
                if (p.getValue() + 1 < k) {
                    stack.addLast(new Pair<Character, Integer>(p.getKey(), p.getValue() + 1));
                }
            }
        }
        
        StringBuilder ans = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair<Character, Integer> p = stack.removeLast();
            for (int i = 0; i < p.getValue(); i++) {
                ans.append(p.getKey());
            }
        }
        return ans.reverse().toString();
        
    }
}