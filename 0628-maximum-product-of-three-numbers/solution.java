class Solution {
    public int maximumProduct(int[] nums) {
        
        //not mine

        Arrays.sort(nums);
        int case1 = nums[0]*nums[1]*nums[nums.length-1];
        int case2 = nums[nums.length-1]*nums[nums.length-2]*nums[nums.length-3];

        int maxProduct = Integer.max(case1, case2);
        return maxProduct;
       
        // int nums2[] = new int[nums.length];

        // for(int i=0; i<nums.length; i++)
        // {
        //     if(nums[i] < 0)
        //     {
        //         nums2[i] = nums[i]*(-1);
        //     }

        //     else
        //     {
        //         nums2[i] = nums[i];
        //     }
        // }

        // Stack<Integer> stack = new Stack<Integer>();
        // int c=0;

        // while(c<3)
        // {
        //     int max= -99999;
        //     int index = 0;
            
        //     for(int i=0; i<nums2.length; i++)
        //     {
        //         //if(max<= nums2[i] && !checkStack(stack, i))
                
        //         if(max <= nums2[i] && !stack.contains(i))
        //         {
        //             max = nums2[i];
        //             index = i;
        //         }
        //     }

        //     stack.push(index);
        //     c++;
        // }

        // int product=1;

        // while(!stack.empty())
        // {
        //     product*=nums[stack.peek()];
        //     stack.pop();
        // }

        // return product;
    }

    // boolean checkStack(Stack<Integer> stack , int i)
    // {
    //     int x= stack.peek();

    //     stack.pop();

    //     if( x == i)
    //     {
    //         stack.push(x);
    //         return true;
    //     }

    //     else
    //     {
    //         checkStack(stack , i);
    //         stack.push(x);
    //     }

    //     return false;
    // }
}