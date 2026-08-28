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
    String s,d;
    public String getDirections(TreeNode root, int startValue, int destValue) {
        
        int i=0;StringBuilder sb=new StringBuilder();
        dFS(root,startValue,destValue,sb);

        if(startValue==root.val) return d;

        char[] sa=s.toCharArray(),da=d.toCharArray();
        int ns=sa.length,nd=da.length;
        while(i<ns&&i<nd&&sa[i]==da[i]) i++;

        int j=i;
        while(j<ns) {sb.append("U");j++;}
        while(i<nd) sb.append(da[i++]);
        
        return sb.toString();
    }
    void dFS(TreeNode root,int st,int en,StringBuilder sb){
        if(root==null) return;

        sb.append("L");
        dFS(root.left,st,en,sb);
        sb.deleteCharAt(sb.length()-1);
        
        if(root.val==st) s=sb.toString();
        if(root.val==en) d=sb.toString();
        
        sb.append("R");
        dFS(root.right,st,en,sb);
        sb.deleteCharAt(sb.length()-1);

    }
}