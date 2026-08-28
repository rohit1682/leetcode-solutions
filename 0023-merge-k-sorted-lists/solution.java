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
    public ListNode mergeKLists(ListNode[] lists) {      
        ListNode head = null;
        while(true) {
            int min = Integer.MAX_VALUE;
            ListNode node = null;
            int flag = 0;
            int index = -1;
            for(int i=0; i<lists.length; i++) {
                if(lists[i] != null && min >= lists[i].val) {
                    flag = 1;
                    min = lists[i].val;
                    node = lists[i];
                    index = i;
                }
            }
            if(flag == 0) break;
            ListNode newNode = new ListNode(node.val);
            if(head == null) head = newNode;
            else {
                ListNode current = head;
                while(current.next != null) current = current.next;
                current.next = newNode;
            }
            lists[index] = node.next;
        }

        return head;
    }
}