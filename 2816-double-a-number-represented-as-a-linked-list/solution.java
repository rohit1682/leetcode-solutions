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
    public ListNode doubleIt(ListNode head) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode prev = dummy;
        ListNode current = head;

        while (current != null) {
            if (current.val * 2 >= 10) {
                prev.val += 1;
            }
            current.val = (current.val * 2) % 10;
            prev = prev.next;
            current = current.next;
        }
        
        return dummy.val > 0 ? dummy : head;
    }
}

// class Solution {
//     public ListNode doubleIt(ListNode head) {
    
//         if(head == null) return null;
//         if(head.next == null && head.val < 5) {
//             ListNode newNode = new ListNode(head.val * 2);
//             return newNode;
//         }

//         ListNode current = head;
//         while(current.next != null) current= current.next;

//         int carry = 0;
//         while(current != head) {
//             ListNode traverse = head;
//             while(traverse.next != current) traverse = traverse.next;

//             current.val = (current.val * 2) + carry;
//             carry = 0;
//             if(current.val >= 10) {
//                 int temp = current.val % 10;
//                 current.val /= 10;
//                 carry = current.val % 10;
//                 current.val = temp;
//             } 
//             current = traverse;
//         }

//         head.val = (head.val * 2) + carry;

//         if(head.val >= 10) {
//             int temp = head.val % 10;
//             head.val /= 10;
//             carry = head.val % 10;
//             head.val = temp;

//             ListNode newNode = new ListNode(carry);
//             newNode.next = head;
//             head = newNode;
//         }

//         return head;
//     }
// }

    