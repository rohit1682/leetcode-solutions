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
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;  
        ListNode current = head;
    
        while(current != null) { 
            ListNode next = current.next; 
            current.next = prev;
            prev = current;
            current = next;
        }
       return prev; 
    }
}

// class Solution {
//     public ListNode reverseList(ListNode head) {
//         if(head == null || head.next == null) return head;
//         ListNode temp = head;
//         ListNode tail = null;
//         int length = 0;
//         while(temp.next != null) {
//             temp = temp.next;
//             length++;
//         }    
//         tail = temp;
//         temp = head;
//         head = tail;
//         tail = temp;
        
//         ListNode before = null;
//         ListNode after = null;
        
//         for(int i=0; i<length; i++)
//         {
//             after = temp.next;
//             temp.next = before;
//             before = temp;
//             temp = after;
//         }

//         return head;
//     }
// }