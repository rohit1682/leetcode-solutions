class Solution {
    public long[] sumOfThree(long num) {

        //not mine

        if(num%3!=0)
        {
            return new long[] {};
        }

        long a=num/3;
        
        return new long[] {a-1,a,a+1};


        // long result[] = new long[3];
        // int flag=0;

        // for(long i=0; i<num; i++)
        // {
        //     if (((i)+(i+1)+(i+2)) == num)
        //     {
        //         result[0] = i;
        //         result[1] = i+1;
        //         result[2] = i+2;
                
        //         flag=1;

        //         break;
        //     }
        // }

        // if(flag == 1)
        // {
        //     return result;
        // }

        // else
        // {
        //     return new long[0];
        // }

    }
}