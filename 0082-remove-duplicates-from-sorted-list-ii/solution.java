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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode curr = head;

        while(curr != null) {
            while(curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            if(pre.next == curr) {
                pre = pre.next;
            } else {
                pre.next = curr.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}

//this removes dupliates only
// class Solution {
//     public ListNode deleteDuplicates(ListNode head) {
//         HashMap<Integer, ListNode> hash = new HashMap<>();
//         while(head!=null) {
//             hash.put(head.val, head);
//             head=head.next;
//         }
//         ListNode ptr=head;
//         for (Map.Entry<Integer, ListNode> entry : hash.entrySet()) {
//             ListNode value = entry.getValue();
//             if(head==null) {
//                 head = value;
//                 ptr=value;
//                 ptr.next=null;
//             }
//             else {
//                 ptr.next=value;
//                 ptr=value;
//                 ptr.next=null;
//             }
//         }
//         return head;
//     }
// }