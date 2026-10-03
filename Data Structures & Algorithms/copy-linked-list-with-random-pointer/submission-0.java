/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        
        Node curr = head, next;

        while (curr != null) {
            next = curr.next;
            curr.next = new Node(curr.val);
            curr.next.next = next;
            curr = next;
        }

        Node newhead = head.next;
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        curr = head;
        while (curr != null) {
            next = curr.next;
            curr.next = next.next;
            if (next.next != null) {
                next.next = next.next.next;
            }
            curr = curr.next;
        }

        return newhead;
    }
}
