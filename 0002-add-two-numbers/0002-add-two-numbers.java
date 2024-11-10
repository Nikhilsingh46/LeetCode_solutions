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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
         // Create a dummy node to form the result list
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;

        // Traverse both lists
        while (l1 != null || l2 != null || carry != 0) {
            // Get values from the current nodes (0 if the node is null)
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            
            // Calculate the sum and update carry
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            
            // Create a new node for the digit in the sum
            current.next = new ListNode(sum % 10);
            current = current.next;

            // Move to the next nodes in the lists, if available
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // Return the next node of dummy, which is the head of the result list
        return dummy.next;
    }
}