class Node {
    Integer timestamp;
    Integer price;
    public Node(int timestamp, int price) {
        this.timestamp = timestamp;
        this.price = price;
    }
}

class StockPrice {
    int latestTime;
    PriorityQueue<Node> maxHeap;
    PriorityQueue<Node> minHeap;
    HashMap<Integer, Integer> map;
    
    public StockPrice() {
        latestTime = 0;
        maxHeap = new PriorityQueue<>((a, b) -> b.price.compareTo(a.price));
        minHeap = new PriorityQueue<>((a, b) -> a.price.compareTo(b.price));
        map = new HashMap<>();
    }
    
    public void update(int timestamp, int price) {
        latestTime = Math.max(latestTime, timestamp);
        map.put(timestamp, price);
        minHeap.add(new Node(timestamp, price));
        maxHeap.add(new Node(timestamp, price));
    }
    
    public int current() {
        return map.get(latestTime);
    }
    
    public int maximum() {
        Node max = maxHeap.peek();
        while (!map.get(max.timestamp).equals(max.price)) {
            maxHeap.poll();
            max = maxHeap.peek();
        }
        return max.price;
    }
    
    public int minimum() {
        Node min = minHeap.peek();
        while (!map.get(min.timestamp).equals(min.price)) {
            minHeap.poll();
            min = minHeap.peek();
        }
        return min.price;
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */