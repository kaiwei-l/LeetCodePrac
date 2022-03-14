/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode root = dummy;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>() {
            public int compare(ListNode node1, ListNode node2) {
                if (node1.val > node2.val) return 1;
                if (node1.val < node2.val) return -1;
                return 0;
            }
        }); 
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                minHeap.offer(lists[i]);
            }
        }
        while (!minHeap.isEmpty()) {
            ListNode curr = minHeap.remove();
            if (curr.next != null) {
                ListNode next = curr.next;
                minHeap.offer(next);
            }
            root.next = curr;
            root = root.next;
        }
        return dummy.next;
    }
}