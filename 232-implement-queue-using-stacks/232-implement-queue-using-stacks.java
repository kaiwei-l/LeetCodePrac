class MyQueue {
    ArrayDeque<Integer> s1;
    ArrayDeque<Integer> s2;
    int size;
    
    public MyQueue() {
        s1 = new ArrayDeque<>();
        s2 = new ArrayDeque<>();
        size = 0;
    }
    
    public void push(int x) {
        s1.addLast(x);
        size++;
    }
    
    public int pop() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.addLast(s1.removeLast());
            }
            size--;
            return s2.removeLast();
        } else {
            size--;
            return s2.removeLast();
        }
    }
    
    public int peek() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                s2.addLast(s1.removeLast());
            }
            int ans = s2.getLast();
            return ans;
        } else {
            int ans = s2.getLast();
            return ans;
        }
    }
    
    public boolean empty() {
        return size == 0;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */