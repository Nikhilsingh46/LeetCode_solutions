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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k <= 1) return head;

        // Dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Pointers
        ListNode prevGroupEnd = dummy;

        while (true) {
            // Find the end of the current group
            ListNode groupStart = prevGroupEnd.next;
            ListNode groupEnd = prevGroupEnd;
            for (int i = 0; i < k && groupEnd != null; i++) {
                groupEnd = groupEnd.next;
            }

            // If there are fewer than k nodes, break
            if (groupEnd == null) break;

            // Save the next group's start
            ListNode nextGroupStart = groupEnd.next;

            // Reverse the current group
            reverseGroup(groupStart, groupEnd);

            // Connect the reversed group with the previous part
            prevGroupEnd.next = groupEnd;
            groupStart.next = nextGroupStart;

            // Move the prevGroupEnd pointer
            prevGroupEnd = groupStart;
        }

        return dummy.next;
    }

    private void reverseGroup(ListNode start, ListNode end) {
        ListNode prev = null;
        ListNode current = start;

        while (prev != end) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
    }
}