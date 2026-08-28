/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 */

bool treeCheck(struct TreeNode* p, struct TreeNode* q)
{
    if(!p && !q)
    {
        return true;
    }

    if( ( p && !q ) || ( !p && q ) || (p->val != q->val))
    {
        return false;
    }

    if (p->val == q->val) return treeCheck(p->left, q->right) && treeCheck(p->right, q->left);
    
    return false;
}

bool isSymmetric(struct TreeNode* root){
    return treeCheck(root->left, root->right);
}