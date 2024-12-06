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
        // Create a dummy node to simplify edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Initialize two pointers
        ListNode first = dummy;
        ListNode second = dummy;

        // Step 1: Move the first pointer n + 1 steps ahead
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        // Step 2: Move both pointers until the first pointer reaches the end
        while (first != null) {
            first = first.next;
            second = second.next;
        }

        // Step 3: Remove the nth node
        second.next = second.next.next;

        // Return the head of the modified list
        return dummy.next;
    }
}
