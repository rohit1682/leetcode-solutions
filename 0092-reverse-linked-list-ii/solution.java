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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode sentinalNode = new ListNode(0,head);
        var temp = sentinalNode;
        
        for(int i = 0;i<left-1;i++){
            temp = temp.next;
        }
        var start = temp.next;
        for(int i = 0 ;start!=null && start.next!=null && i < right - left;i++){
            var next = start.next;
            start.next = start.next.next;
            next.next = temp.next;
            temp.next = next; 
        }
        return sentinalNode.next;
    }
}