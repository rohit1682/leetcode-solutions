/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var deepestLeavesSum = function(root) {
    let max = maxDepth(root);
    return sumNode(root, max-1, 0);
};

function maxDepth(root) {
    return root == null ? 0 : 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
}

function sumNode(root, targetDepth, currentDepth) {
    if(!root) return 0;  
    if(currentDepth === targetDepth) return root.val; 
    return sumNode(root.left, targetDepth, currentDepth + 1) + sumNode(root.right, targetDepth, currentDepth + 1); 
}