public class Node {
    int val;
    Node next;
    Node prev;
    public Node(int val, Node next, Node prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}
class Solution {
    
    public int findTheWinner(int n, int k) {
        Node head = new Node(1, null, null);
        Node currNode = head;
        for (int i = 2; i <= n; i++) {
            Node newNode = new Node(i, null, null);
            currNode.next = newNode;
            newNode.prev = currNode;
            currNode = currNode.next;
        }
        currNode.next = head;
        head.prev = currNode;
        int size = n;
        Node curr = head;
        while (size != 1) {
            for (int i = 0; i < k; i++) {
                curr = curr.next;
            }
            Node secondLast = curr.prev.prev;
            secondLast.next = curr;
            curr.prev = secondLast;
            size--;
        }
        return curr.val;
    }
}