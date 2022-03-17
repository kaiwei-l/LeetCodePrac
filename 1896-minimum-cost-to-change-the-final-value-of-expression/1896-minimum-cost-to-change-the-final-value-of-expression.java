class Solution {
    public int minOperationsToFlip(String expression) {
        ArrayDeque<Pair<Character, Integer>> stack = new ArrayDeque<>();
        Pair<Character, Integer> p;
        int cost1 = 0, cost2 = 0;
        char val1;
        char val2;
        char op;
        
        for (int i = 0; i < expression.length(); i++) {
            char currChar = expression.charAt(i);
            if (currChar == '(' || currChar == '&' || currChar == '|') {
                stack.addLast(new Pair<Character, Integer>(currChar, 0));
            } else {
                if (currChar == ')') {
                    p = stack.removeLast();
                    stack.removeLast();
                } else {
                    p = new Pair<Character, Integer>(currChar, 1);
                }
                while (!stack.isEmpty() && (stack.getLast().getKey() == '&' || stack.getLast().getKey() == '|')) {
                    op = stack.removeLast().getKey();
                    val2 = p.getKey();
                    cost2 = p.getValue();
                    val1 = stack.getLast().getKey();
                    cost1 = stack.getLast().getValue();
                    stack.removeLast();
                    
                    if (op == '&' && val1 == '1' && val2 == '1') p = new Pair<Character, Integer>('1', Math.min(cost1, cost2));
                    if (op == '&' && val1 == '1' && val2 == '0') p = new Pair<Character, Integer>('0', 1);
                    if (op == '&' && val1 == '0' && val2 == '1') p = new Pair<Character, Integer>('0', 1);
                    if (op == '&' && val1 == '0' && val2 == '0') p = new Pair<Character, Integer>('0', Math.min(1 + cost1, 1 + cost2));
                    if (op == '|' && val1 == '1' && val2 == '1') p = new Pair<Character, Integer>('1', Math.min(1 + cost1, 1 + cost2));
                    if (op == '|' && val1 == '1' && val2 == '0') p = new Pair<Character, Integer>('1', 1);
                    if (op == '|' && val1 == '0' && val2 == '1') p = new Pair<Character, Integer>('1', 1);
                    if (op == '|' && val1 == '0' && val2 == '0') p = new Pair<Character, Integer>('0', Math.min(cost1, cost2));
                }
                stack.addLast(p);
            }
        }
        return stack.removeLast().getValue();
    }
}