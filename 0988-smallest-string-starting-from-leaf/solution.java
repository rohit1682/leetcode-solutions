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

    public String smallestStr="";

    public String smallestFromLeaf(TreeNode root) {
        
        dfs(root,new StringBuilder());
        return smallestStr;
    }

    public void dfs(TreeNode root, StringBuilder CurrStr)
    {
        if(root==null)
        {
            return;
        }

        CurrStr.insert(0,(char)(root.val + 'a'));

        if(root.left==null && root.right==null)
        {
            if(smallestStr == "")
            {
               smallestStr = CurrStr.toString();
            }
            else if( smallestStr.compareTo(CurrStr.toString()) > 0 )
            {
                smallestStr = CurrStr.toString();
            }

            return;
        }

        if(root.left != null)
        {
            dfs(root.left,CurrStr);
            CurrStr.deleteCharAt(0);
        }

        if(root.right != null)
        {
            dfs(root.right,CurrStr);
            CurrStr.deleteCharAt(0);
        }

        return;
    }
}