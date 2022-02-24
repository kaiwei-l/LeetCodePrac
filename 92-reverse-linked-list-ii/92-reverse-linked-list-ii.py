# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        def reverseHelp(head, count):
            prev = None
            curr = head
            newTail = head
            while count != 0:
                temp = curr.next
                curr.next = prev
                prev = curr
                curr = temp
                count -= 1
            head = prev
            newTail.next = curr
            return head
        length = right - left + 1
        if left == 1:
            return reverseHelp(head, length)
        else:
            i = 1
            curr = head
            while i != left - 1:
                curr = curr.next
                i += 1
            curr.next = reverseHelp(curr.next, length)
            return head