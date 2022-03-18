/**
 * Definition for a binary tree node.
 * class Node {
 *     char val;
 *     Node left;
 *     Node right;
 *     Node() {this.val = ' ';}
 *     Node(char val) { this.val = val; }
 *     Node(char val, Node left, Node right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isOperator(char c) {
        if (c == '+' || c == '-' || c == '*' || c == '/') return true;
        return false;
    }
    
    // Check if c1 >= c2. c1 is on the stack
    public boolean shouldPopOperator(char c1, char c2) {
        if ((c1 == '*' || c1 == '/' || c1 == '+' || c1 == '-') && (c2 == '+' || c2 == '-')) return true;
        if ((c1 == '+' || c1 == '-') && (c2 == '*' || c2 == '/')) return false;
        if ((c1 == '*' || c1 == '/') && (c2 == '*' || c2 == '/')) return true;
        return false;
    }
    
    public List<Character> getPostfix(String prefix) {
        List<Character> postfix = new ArrayList<Character>();
        ArrayDeque<Character> s = new ArrayDeque<>();
        
        for (int i = 0; i < prefix.length(); i++) {
            char currChar = prefix.charAt(i);
            if (currChar == '+' || currChar == '-' || currChar == '*' || currChar == '/') {
                while (!s.isEmpty() && shouldPopOperator(s.getLast(), currChar)) {
                    postfix.add(s.removeLast());
                }
                s.addLast(currChar);
            } else if (currChar == '(') {
                s.addLast(currChar);
            } else if (currChar == ')') {
                while (s.getLast() != '(') {
                    postfix.add(s.removeLast());
                }
                s.removeLast();
            } else {
                postfix.add(currChar);
            }
        }
        while (!s.isEmpty()) {
            postfix.add(s.removeLast());
        }
        return postfix;
    }
    public Node expTree(String s) {
        List<Character> postfix = getPostfix(s);
        ArrayDeque<Node> stack = new ArrayDeque<Node>();
        for (int i = 0; i < postfix.size(); i++) {
            char currChar = postfix.get(i);
            if (currChar == '+' || currChar == '-' || currChar == '*' || currChar == '/') {
                Node op = new Node(currChar);
                Node expRight = stack.removeLast();
                Node expLeft = stack.removeLast();
                op.left = expLeft;
                op.right = expRight;
                stack.addLast(op);
            } else {
                Node num = new Node(currChar);
                stack.addLast(num);
            }
        }
        return stack.removeLast();
    }
}