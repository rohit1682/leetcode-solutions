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
    int sum = 0;
    private int solveDFS(TreeNode root) {
        if (root == null)
            return 0;
        int coins = solveDFS(root.left) + solveDFS(root.right) + root.val - 1;
        sum += Math.abs(coins);
        return coins;
    }
    public int distributeCoins(TreeNode root) {
        solveDFS(root);
        return sum;
    }
}