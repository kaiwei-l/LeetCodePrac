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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pointer = head;
        int size = 0;
        while (pointer != null) {
            size++;
            pointer = pointer.next;
        }
        if (size == 0) return null;
        int target = size - n;
        if (target < 0) return null;
        
        ListNode dummy = new ListNode(-1, head);
        pointer = dummy;
        for (int i = 0; i < target; i++) {
            pointer = pointer.next;
        }
        pointer.next = pointer.next.next;
        return dummy.next;
    }
}