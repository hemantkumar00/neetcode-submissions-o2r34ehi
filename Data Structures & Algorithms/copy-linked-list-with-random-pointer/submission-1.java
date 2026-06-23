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
        if(head == null)return null;
        Node dummy = head;
        while(dummy!=null) {
            Node temp = new Node(dummy.val);
            Node next = dummy.next;
            dummy.next = temp;
            temp.next = next;
            dummy = next;
        }
        dummy = head;
        while(dummy != null) {
            Node next = dummy.next;
            Node nextNode = dummy.random != null ? dummy.random.next : null;
            next.random = nextNode;
            dummy = dummy.next.next;
        }
        dummy = head;
        Node copyHead = head.next;
        while(dummy != null) {
            Node copy = dummy.next;
            dummy.next = copy.next;
            if (copy.next != null)
                copy.next = copy.next.next;
            dummy = dummy.next;
        }
        return copyHead;
    }
}
