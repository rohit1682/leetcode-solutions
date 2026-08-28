class Solution {
    public int climbStairs(int n) {

        //not mine

        if(n==1) return 1;
        
        if(n==2) return 2;

        int[] a =  new int[n];
        a[0]=1;
        a[1]=2;

        for(int i=2;i<n;i++){
            a[i]=a[i-1]+a[i-2];
        }
        return a[n-1];

        // int step1 = (int) ((fact(n))/(fact(1)*fact(n-1)));
        // int step2 = (int) ((fact(n))/(fact(2)*fact(n-2)));

        // int max;
        // if(step1 > step2)
        // {
        //     max= step1;
        // }
        // else
        // {
        //     max=step2;
        // }

        //  return max;



    }

    // int fact(int x)
    // {
    //     int prod=1;
    //     while(x>=1)
    //     {
    //         prod*=x;
    //         x--;
    //     }
    //     return prod;
    // }
}