# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def reverseKGroup(self, head: Optional[ListNode], k: int) -> Optional[ListNode]:
        def reverseEntireList(head, length):
            prev = None
            curr = head
            newTail = head
            while length != 0:
                tmp = curr.next
                curr.next = prev
                prev = curr
                curr = tmp
                length -= 1
            newTail.next = curr
            return prev

        count = 0
        tmp = head
        while tmp != None:
            tmp = tmp.next
            count += 1
        groups = count // k
        dummy = ListNode(0, head)
        dummyCopy = dummy
        for i in range(groups):
            # left = i * k + 1
            # right = (i + 1) * k
            dummy.next = reverseEntireList(dummy.next, k)
            for i in range(k):
                dummy = dummy.next
        return dummyCopy.next
            