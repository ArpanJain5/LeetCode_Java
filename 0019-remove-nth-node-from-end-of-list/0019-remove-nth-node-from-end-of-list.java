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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode runner = head;
        while (n > 1) {
            n--;
            runner = runner.next;
        }
        ListNode prev = new ListNode();
        prev.next = head;
        ListNode result = prev;
        while (runner != null && runner.next != null) {
            runner = runner.next;
            head = head.next;
            prev = prev.next;
        }
        prev.next = head.next;
        return result.next;
    }
}