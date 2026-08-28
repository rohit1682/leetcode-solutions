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

    // if(p!=NULL && q != NULL)
    // {
    //     if(p->val == q->val)
    //     {
    //         treeCheck(p->left,q->left);
    //         treeCheck(p->right,q->right);
    //     }

    //     else 
    //     {
    //         return false;
    //     }
        
    // }

    if( ( p && !q ) || ( !p && q ) || (p->val != q->val))
    {
        return false;
    }

    if (p->val == q->val) return treeCheck(p->left, q->left) && treeCheck(p->right, q->right);
    
    return false;
}

bool isSameTree(struct TreeNode* p, struct TreeNode* q){
    return (treeCheck(p,q));
}
