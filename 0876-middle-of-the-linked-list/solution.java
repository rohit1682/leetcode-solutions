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
    public ListNode middleNode(ListNode head) {
        if(head == null)  return null;
        ListNode current = head;

        ListNode sptr = head;
        ListNode fptr = head;

        while((fptr != null) && (fptr.next != null)) {
            sptr = sptr.next;
            fptr = fptr.next.next;
        }

        return sptr;
    }
}