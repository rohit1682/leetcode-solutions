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
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        
        int left = 0;
        int right = list.size()-1;
        while(left < right && list.get(left) == list.get(right)) {
            left++;
            right--;
        }
        return left >= right;
    }
}
// class Solution {
//     public boolean isPalindrome(ListNode head) {
//         Stack<Integer> stack = new Stack<Integer>();
//         ListNode copy = head;
//         ListNode copy2 = head;
//         int count=0;

//         if(head.next == null)
//         {
//             return true;
//         }

//         while(copy2.next != null)
//         {
//             count++;
//             copy2= copy2.next;
//         }

//         if(count%2 != 0)
//         {
//             while(copy != null)
//             {
//                 stack.push(head.val);
//                 head= head.next;
//                 copy= copy.next.next;
//             }
//         }

//         else
//         {
//             while(copy != null)
//             {
//                 stack.push(head.val);
//                 head= head.next;
//                 copy= copy.next.next;
//             }
//         }

//         while(head != null)
//         {
//             int x= stack.peek();
//             if(x != head.val)
//             {
//                 return false;
//             }
//             stack.pop();
//             head=head.next;
//         }

//         return true;
//     }
// }