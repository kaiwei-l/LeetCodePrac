class Node {
    int val;
    Node prev;
    Node next;
    public Node(int val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class MyCircularDeque {
    public Node head;
    public Node tail;
    public int limit;
    public int size;
    
    public MyCircularDeque(int k) {
        head = new Node(-1);
        tail = new Node(-1);
        head.prev = tail;
        head.next = tail;
        tail.prev = head;
        tail.next = head;
        limit = k;
        size = 0;
    }
    
    public boolean insertFront(int value) {
        if (size + 1 > limit) return false;
        Node newNode = new Node(value);
        newNode.next = head.next;
        newNode.prev = head;
        head.next.prev = newNode;
        head.next = newNode;
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (size + 1 > limit) return false;
        Node newNode = new Node(value);
        newNode.next = tail;
        newNode.prev = tail.prev;
        tail.prev.next = newNode;
        tail.prev = newNode;
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if (size == 0) return false;
        head.next.next.prev = head;
        head.next = head.next.next;
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if (size == 0) return false;
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
        size--;
        return true;
    }
    
    public int getFront() {
        return (size == 0) ? -1 : head.next.val;
    }
    
    public int getRear() {
        return (size == 0) ? -1 : tail.prev.val;
    }
    
    public boolean isEmpty() {
        return (size == 0) ? true : false;
    }
    
    public boolean isFull() {
        return (size == limit) ? true : false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */