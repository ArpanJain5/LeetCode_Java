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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int[] res = new int[]{-1, -1};
        if (head == null || head.next == null || head.next.next == null) {
            return res;
        }
        List<Integer> criticalPoints = new ArrayList<>();
        ListNode prev = head;
        ListNode curr = head.next;
        int index = 2;
        while (curr.next != null) {
            ListNode next = curr.next;
            if ((prev.val < curr.val && curr.val > next.val) ||
                (prev.val > curr.val && curr.val < next.val)) {
                criticalPoints.add(index);
            }
            prev = curr;
            curr = next;
            index++;
        }
        if (criticalPoints.size() < 2) {
            return res;
        }
        int minDistance = criticalPoints.get(1) - criticalPoints.get(0);
        int maxDistance = criticalPoints.get(criticalPoints.size() - 1) - criticalPoints.get(0);
        for (int i = 0; i < criticalPoints.size() - 1; i++) {
            int distance = criticalPoints.get(i + 1) - criticalPoints.get(i);
            minDistance = Math.min(minDistance, distance);
        }
        res[0] = minDistance;
        res[1] = maxDistance;
        return res;
    }
}