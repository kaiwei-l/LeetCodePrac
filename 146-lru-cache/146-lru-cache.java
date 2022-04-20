class DoubleNode {
    int val;
    int key;
    DoubleNode next;
    DoubleNode prev;
    
    public DoubleNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    int size;
    int capacity;
    HashMap<Integer, DoubleNode> map;
    DoubleNode head;
    DoubleNode tail;
    
    public void addNode(DoubleNode node) {
        node.prev = this.head;
        node.next = this.head.next;
        this.head.next.prev = node;
        this.head.next = node;
    }
    
    public void removeNode(DoubleNode node) {
        DoubleNode prev = node.prev;
        DoubleNode next = node.next;
        prev.next = next;
        next.prev = prev;
        
    }
    
    public void moveToHead(DoubleNode node) {
        removeNode(node);
        addNode(node);
    }
    
    public DoubleNode popTail() {
        DoubleNode res = this.tail.prev;
        removeNode(res);
        return res;
    }
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.map = new HashMap<>();
        this.head = new DoubleNode(-1, -1);
        this.tail = new DoubleNode(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public int get(int key) {
        if (this.map.containsKey(key)) {
            DoubleNode node = this.map.get(key);
            moveToHead(node);
            return node.val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if (this.map.containsKey(key)) {
            DoubleNode node = this.map.get(key);
            node.val = value;
            this.map.put(key, node);
            moveToHead(node);
        } else {
            DoubleNode node = new DoubleNode(key, value);
            addNode(node);
            this.map.put(key, node);
            this.size++;
            if (this.size > this.capacity) {
                DoubleNode lru = popTail();
                this.map.remove(lru.key);
                this.size--;
            }
        }
    }
    
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */