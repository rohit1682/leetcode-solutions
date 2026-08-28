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
    public ListNode deleteMiddle(ListNode head) {
        if((head == null) || (head.next == null)) return null;
        ListNode current = head;

        ListNode prev = null;
        ListNode sptr = head;
        ListNode fptr = head;

        while((fptr != null) && (fptr.next != null)) {
            prev = sptr;
            sptr = sptr.next;
            fptr = fptr.next.next;
        }

        prev.next = prev.next.next;

        return head;
    }
}