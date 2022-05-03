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
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        HashMap<Integer, Integer> counter = new HashMap<>();
        ListNode headCopy = head;
        while (headCopy != null) {
            counter.put(headCopy.val, counter.getOrDefault(headCopy.val, 0) + 1);
            headCopy = headCopy.next;
        }
        ListNode dummy = new ListNode(-1, head);
        ListNode pointer = dummy;
        while (pointer.next != null) {
            if (counter.get(pointer.next.val) != 1) {
                pointer.next = pointer.next.next;
            } else {
                pointer = pointer.next;
            }
        }
        return dummy.next;
    }
}