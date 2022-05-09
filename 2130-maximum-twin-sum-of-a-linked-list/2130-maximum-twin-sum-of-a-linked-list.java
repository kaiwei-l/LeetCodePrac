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
    public int pairSum(ListNode head) {
        if (head.next != null && head.next.next == null) {
            return head.val + head.next.val;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int indx = 0;
        ListNode curr = head;
        int maxSum = 0;
        int size = 0;
        while (head != null) {
            map.put(indx, head.val);
            head = head.next;
            size++;
            indx++;
        }
        
        for (int i = 0; i <= size / 2 - 1; i++) {
            int complement = size - 1 - i;
            maxSum = Math.max(maxSum, map.get(i) + map.get(complement));
        }
        return maxSum;
    }
}