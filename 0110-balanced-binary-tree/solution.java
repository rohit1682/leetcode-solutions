/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public boolean isBalanced(TreeNode root) {
        if (root == null)  return true;
		if (Height(root) == -1)  return false;
		return true;
	}
	public int Height(TreeNode root) {
		if (root == null)  return 0;
		int leftHeight = Height(root.left);
		int rightHight = Height(root.right);
		if (leftHeight == -1 || rightHight == -1)  return -1;
        if (Math.abs(leftHeight - rightHight) > 1)  return -1;
		return Math.max(leftHeight, rightHight) + 1;
    }
}

// my correct solution but testcase wrong [1,2,3,4,5,6,null,8]

// class Solution {
//     public boolean isBalanced(TreeNode root) {
//         if(root==null) return true;
//         int total=totalNodes(root);
//         int height=maxDepth(root);

//         int val=(int)(Math.log(total)/Math.log(2));
//         if(val+1 == height) return true;
//         else return false;
//     }

//     int maxDepth(TreeNode root) {
//         if(root==null) return 0;
//         int countleft=1+maxDepth(root.left);
//         int countright=1+maxDepth(root.right);
//         return Math.max(countleft,countright);
//     }

//     int totalNodes(TreeNode root)
//     {
//         if (root == null)
//             return 0;
     
//         int l = totalNodes(root.left);
//         int r = totalNodes(root.right);
     
//         return 1 + l + r;
//     }
// }