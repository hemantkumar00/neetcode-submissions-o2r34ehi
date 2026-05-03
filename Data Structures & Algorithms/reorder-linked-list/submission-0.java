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
        if(head == null || head.next == null || head.next.next == null)return;
        ListNode temp = head;
        int count = 1;
        while(temp!=null){
            temp = temp.next;
            count++;
        }
        count/=2;
        temp = head;
        ListNode pre = head;
        temp = pre.next;
        for(int i=0;i<count-1;i++){
            temp = temp.next;
            pre = pre.next;
        }
        pre.next = null;
        temp = fun(temp);
        pre = head;
        while(pre!=null && temp!=null){
            ListNode temp1 = pre.next;
            pre.next = temp;
            ListNode temp2 = temp.next;
            temp.next = temp1;
            pre = temp1;
            temp = temp2;
        }

    }
    private ListNode fun(ListNode node) {
    ListNode prev = null;
    ListNode curr = node;

    while (curr != null) {
        ListNode next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }

    return prev;
}
}
