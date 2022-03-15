class MedianFinder {
    public PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
    public PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b - a);
    
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        this.maxHeap.add(num);
        this.minHeap.add(this.maxHeap.remove());
        if (this.maxHeap.size() < this.minHeap.size()) {
            this.maxHeap.add(this.minHeap.remove());
        }
    }
    
    public double findMedian() {
        if (this.maxHeap.size() > this.minHeap.size()) {
            return this.maxHeap.peek();
        } else {
            return (double) (this.maxHeap.peek() + this.minHeap.peek()) * 0.5;
        }
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */