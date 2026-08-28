class Solution {
    public int findMinArrowShots(int[][] points) {
        
        // Sort the balloons based on their end coordinates
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        int arrows = 1;
        int prevEnd = points[0][1];
        
        // Count the number of non-overlapping intervals
        for (int i = 1; i < points.length; ++i) {
            if (points[i][0] > prevEnd) {
                arrows++;
                prevEnd = points[i][1];
            }
        }
        
        return arrows;
        
        // int ans[] = new int[(2 * points.length)];
        // boolean check[] = new boolean[(2 * points.length)];

        // int count = 0;
        // for(int i=0; i < points.length; i++)
        // {
        //     ans[count] = points[i][0];
        //     check[count] = false;
        //     count++;

        //     ans[count] = points[i][1];
        //     check[count] = true;
        //     count++;
        // }

        // mysort(ans, check);

        // int maxCount=-1;
        // count=0;
        // for(int i=0; i < check.length; i++)
        // {
        //     if(check[i] == false)
        //     {
        //         count++;
        //     }
        //     else
        //     {
        //         count--;
        //     }

        //     if(maxCount <= count)
        //     {
        //         maxCount = count;
        //     }
        // }

        // return maxCount;
    }

    // void mysort(int[] ans, boolean[] check)
    // {
    //     for(int i=0; i<ans.length-i;i++)   
    //     {     
    //         for(int j=0; j<ans.length-i-1;j++)   
    //         {   
    //             if(ans[j]>ans[j+1])   
    //             {   
    //                 int temp1 = ans[j];   
    //                 ans[j] = ans[j+1];   
    //                 ans[j+1] = temp1;   

    //                 boolean temp2 = check[j];
    //                 check[j] = check[j+1];
    //                 check[j+1] = temp2;
    //             }   
    //         }   
    //     }  
    // }
}