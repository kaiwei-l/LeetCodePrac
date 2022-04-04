class MyQueue {
    int size;
    ArrayDeque<Integer> s1;
    ArrayDeque<Integer> s2;
    
    public MyQueue() {
        this.size = 0;
        this.s1 = new ArrayDeque<>();
        this.s2 = new ArrayDeque<>();
        
    }
    
    public void push(int x) {
        this.s1.addLast(x);
        this.size++;
    }
    
    public int pop() {
        while (!this.s1.isEmpty()) {
            this.s2.addLast(this.s1.removeLast());
        }
        int ans = this.s2.removeLast();
        while (!this.s2.isEmpty()) {
            this.s1.addLast(this.s2.removeLast());
        }
        this.size--;
        return ans;
    }
    
    public int peek() {
        while (!this.s1.isEmpty()) {
            this.s2.addLast(this.s1.removeLast());
        }
        int ans = this.s2.getLast();
        while (!this.s2.isEmpty()) {
            this.s1.addLast(this.s2.removeLast());
        }
        return ans;
    }
    
    public boolean empty() {
        if (this.size == 0) return true;
        return false;
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