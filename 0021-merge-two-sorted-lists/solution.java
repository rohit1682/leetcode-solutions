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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        while(list1 != null && list2 != null) {
            int val;
            if(list1.val < list2.val) {
                val = list1.val;
                list1 = list1.next;
            }
            else {
                val = list2.val;
                list2 = list2.next;
            }
            ListNode newNode = new ListNode(val);
            if(head == null) head = newNode;
            else {
                ListNode current = head;
                while(current.next != null) current = current.next;
                current.next = newNode;
            }
        }
        while(list1 != null) {
            ListNode newNode = new ListNode(list1.val);
            if(head == null) head = newNode;
            else {
                ListNode current = head;
                while(current.next != null) current = current.next;
                current.next = newNode;
            }
            list1 = list1.next;
        }
        while(list2 != null) {
            ListNode newNode = new ListNode(list2.val);
            if(head == null) head = newNode;
            else {
                ListNode current = head;
                while(current.next != null) current = current.next;
                current.next = newNode;
            }
            list2 = list2.next;
        }

        return head;
    }
}