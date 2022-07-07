class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (String t : tokens) {
            if (stack.isEmpty()) {
                stack.addLast(Integer.valueOf(t));
            } else {
                if (isOperator(t)) {
                    int r = stack.removeLast();
                    int l = stack.removeLast();
                    stack.addLast(operate(l, r, t));
                } else {
                    stack.addLast(Integer.valueOf(t));
                }
            }
        }
        return stack.removeLast();
    }
    
    public int operate(int l, int r, String t) {
        if (t.equals("+")) {
            return l + r;
        } else if (t.equals("-")) {
            return l - r;
        } else if (t.equals("*")) {
            return l * r;
        } else {
            return l / r;
        }
    }
        
    public boolean isOperator(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) return true;
        return false;
    }
}