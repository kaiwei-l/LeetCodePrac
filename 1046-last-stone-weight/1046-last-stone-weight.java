class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a, b) -> b.compareTo(a));
        
        for (int s : stones) {
            maxHeap.add(s);
        }
        
        while (maxHeap.size() > 1) {
            int x = maxHeap.poll();
            int y = maxHeap.poll();
            if (x != y) maxHeap.add(Math.abs(x - y));
        }
        if (maxHeap.size() == 1) {
            return maxHeap.poll();
        } else {
            return 0;
        }
    }
}