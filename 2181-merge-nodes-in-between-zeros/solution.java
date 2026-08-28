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
    public ListNode mergeNodes(ListNode head) {
        ListNode current = head.next;
        ListNode root = new ListNode(0);
        ListNode tail = root;
        int data=0;
        while(current!=null)
        {
            if(current.val!=0)
            {
              data=data+current.val;
            }
            else
            {
                tail.next=new ListNode(data);
                data=0;
                tail=tail.next;
            }
            current=current.next;
        }
        
        return root.next;
    }
}