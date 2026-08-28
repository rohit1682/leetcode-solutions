class Solution {
    public int reverse(int x) {
        int num=0;
        int copy=x;
        while(copy!=0)
        {
            int temp=copy%10;
            num=(num*10)+temp;
            copy=copy/10;

            if(num%10!=temp)
            {
                return 0;
            }
        }
        
        return num;
    }
}