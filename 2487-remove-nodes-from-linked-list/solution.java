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
    public ListNode removeNodes(ListNode head) {
        if(head == null || head.next == null) return head;

        Stack<ListNode> stack = new Stack<ListNode>();

        ListNode current = head;
        stack.push(current);
        current = current.next;

        while(current != null) {
            if(current.val <= stack.peek().val) {
                stack.push(current);
            }
            else if(current.val > stack.peek().val) {
                ListNode temp = null;
                while((!stack.empty()) && (current.val > stack.peek().val)) {
                    temp = stack.pop();
                }
                if(temp == head) head = current;
                else stack.peek().next = current;
                stack.push(current);
            }
            current = current.next;
        }
        return head;
    }
}