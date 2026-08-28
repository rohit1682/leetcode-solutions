class Solution {
    public int integerBreak(int n) {
        int result;

        if (n<=3)
        {
            return n-1;
        }

        else
        {
            int quotient = (int) n/3;
            int reminder = (int) n%3;

            if(reminder == 1)
            {
                result = (int) Math.pow(3, quotient-1);
                result*= 4;
            } 

            else if(reminder == 0)
            {
                result = (int) Math.pow(3,quotient);
            }

            else
            {
                result = (int) Math.pow(3, quotient);
                result*= 2;
            }
        }

        return result;
    }
}