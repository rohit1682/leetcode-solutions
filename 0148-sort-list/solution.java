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
    public ListNode sortList(ListNode head) {
        if (head==null || head.next==null) {
            return head;
        }
        ListNode mid = Mid_Of_Head(head);
        ListNode head2 = mid.next;
        mid.next = null;
        ListNode t1 = sortList(head);
        ListNode t2 = sortList(head2);
        return merge(t1,t2); 
    }
    public ListNode Mid_Of_Head(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode head;
        if (head1==null) {
            return head2;
        }
        if (head2==null) {
            return head1;
        }
        if (head1.val<head2.val) {
            head = head1;
            head1 = head1.next;
        }
        else {
            head = head2;
            head2 = head2.next;
        }
        ListNode t = head;
        while (head1!=null && head2!=null) {
            if (head1.val<head2.val) {
                t.next = head1;
                head1 = head1.next;
                t = t.next;
            }
            else {
                t.next = head2;
                head2 = head2.next;
                t = t.next;
            }
        }
        if (head1==null) {
            t.next = head2;
        }
        if (head2==null) {
            t.next = head1;
        }
        return head;
    }
}

// class Solution {
//     public ListNode sortList(ListNode head) {
//         if(head == null || head.next == null) return head;
//         ListNode current = head;
//         ListNode ans = null;
//         while(current != null) {
//             ListNode newNode = new ListNode(current.val);
//             if(ans == null) ans = newNode;
//             else {
//                 ListNode temp = ans;
//                 while(newNode.val < temp.val || temp.next != null) {
//                     temp = temp.next;
//                 }
//                 if(temp == ans) {
//                     newNode.next = ans;
//                     ans = newNode;
//                 }
//                 else temp.next = newNode;
//             }
//             current = current.next;
//         }
//         return ans;
//     }
// }