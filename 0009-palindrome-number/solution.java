class Solution {
    public boolean isPalindrome(int x) {
        int copy=x;
        int result=0;    
        while(copy!=0)
        {
            int temp=copy%10;
            copy=copy/10;
            result=(result*10)+temp;
        }
        if(result==x&&x>=0)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
}