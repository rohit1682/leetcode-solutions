/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> address = new HashSet<ListNode>();
        while(headA!=null) {
            address.add(headA);
            headA=headA.next;
        }
        while(headB!=null) {
            boolean res=address.add(headB);
            if(res==false) return headB;
            headB=headB.next;
        }
        return null;
    }
}