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
    static ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        ListNode after = null;
        while(curr!=null){
            after = curr.next;
            curr.next = prev;
            prev = curr;
            curr = after;
        }
        return prev;
    }
    public ListNode doubleIt(ListNode head) {
        ListNode newHead = reverse(head);
        int carry = 0;
        ListNode t = newHead;
        ListNode temp = null;
        while(t!=null){
            int sum = (2*t.val)+carry;
            if(sum<10){
                ListNode x = new ListNode(sum);
                x.next = temp;
                temp = x;
                carry = 0;
            }else{
                ListNode x = new ListNode(sum%10);
                x.next = temp;
                temp = x;
                carry = sum/10;
            }
            t = t.next;
        }
        if(carry!=0){
            ListNode x = new ListNode(carry);
            x.next = temp;
            temp = x;
        }
        return temp;
    }
}