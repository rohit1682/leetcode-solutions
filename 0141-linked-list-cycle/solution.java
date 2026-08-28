/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null ) return false;
        ListNode sptr = head;
        ListNode fptr = head;

        while((fptr != null) && (fptr.next != null))
        {
            sptr = sptr.next;
            fptr = fptr.next.next;
            if(sptr == fptr) return true;
        }
        return false;
    }
}