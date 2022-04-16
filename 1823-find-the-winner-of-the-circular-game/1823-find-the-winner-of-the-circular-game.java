class Node {
    public int val;
    public Node next;
    
    Node (int val) {
        this.val = val;
    }
}

class Solution {
    public int findTheWinner(int n, int k) {
        if (n == 1) return 1;
        
        Node head = new Node(1);
        int size = n;
        Node curr = head;
        for (int i = 2; i <= n; i++) {
            Node newNode = new Node(i);
            curr.next = newNode;
            curr = curr.next;
        }
        curr.next = head;
        
        curr = head;
        while (size != 1) {
            if (k == 1) {
                curr = curr.next;
                size--;
            } else {
                for (int i = 0; i < k - 2; i++) {
                    curr = curr.next;
                }
                curr.next = curr.next.next;
                curr = curr.next;
                size--;   
            }
        }
        return curr.val;
    }
}