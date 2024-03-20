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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode tail2=list2,head2=list2;
        while(tail2.next!=null){
            tail2=tail2.next;
        }
        ListNode ath=list1,bth=list1;
        for(int i=0;i<a-1;i++){
            ath=ath.next;
        }
        for(int i=0;i<b+1;i++){
            bth=bth.next;
        }
        ath.next=head2;
        tail2.next=bth;
        return list1;   
    }
}