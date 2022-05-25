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
    public void reorderList(ListNode head) {
        ArrayDeque<ListNode> s = new ArrayDeque<>();
        ListNode pointer = head;
        int size = 0;
        while (pointer != null) {
            s.addLast(pointer);
            size++;
            pointer = pointer.next;
        }
        pointer = head;
        for (int i = 1; i <= size / 2; i++) {
            ListNode temp = pointer.next;
            ListNode tail = s.removeLast();
            pointer.next = tail;
            tail.next = temp;
            pointer = temp;
        }
        pointer.next = null;
    }
}