/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

bool element(int x, struct ListNode* start)
{
   while(start != NULL)
    {
        if(x == start->val)
        {
            return false;
        }
        start= start->next;
    }
    return true;
}

struct ListNode* push_val(struct ListNode* start, int val)
{
    struct ListNode* result= ( struct ListNode*) malloc( sizeof(struct ListNode) );
    result->next= NULL;
    result->val = val;

    if(start == NULL)
    {
        start= result;
    }

    else
    {
        struct ListNode* copy= start;
        while(copy->next != NULL)
        {
            copy= copy->next;
        }

        copy->next= result;
    }

    return start;
}

struct ListNode* deleteDuplicates(struct ListNode* head){
    
    struct ListNode* start= NULL;
        
    while(head!= NULL)
    {
        bool check = element(head->val, start);

        if(check)
        {
            start= push_val(start, head->val);
        }

        head= head->next;
    }
        
    return start;
}

