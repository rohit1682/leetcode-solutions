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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null) return head;
        
        int count=1;
        ListNode ptr=head;
        while(ptr.next!=null) {
            ptr=ptr.next;
            count++;
        }
        ptr.next = head;
        k = k % count;
        k = count - k;

        while (k-- > 0) {
            ptr = ptr.next;
        }

        head = ptr.next;
        ptr.next = null;

        return head;
    }
}