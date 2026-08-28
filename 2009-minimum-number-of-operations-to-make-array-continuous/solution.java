class Solution {

    public int minOperations(int[] nums){

        //not mine

        Arrays.sort(nums);

        int uniqueLen = 1;

        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] != nums[i - 1]) {
                nums[uniqueLen++] = nums[i];
            }
        }
        
        int ans = nums.length;

        for (int i = 0, j = 0; i < uniqueLen; ++i) {

            while (j < uniqueLen && nums[j] - nums[i] <= nums.length - 1) 
            {
                ++j;
            }

            ans = Math.min(ans, nums.length - (j - i));
        }
        
        return ans;

    }

    // public int minOperations(int[] nums){

    //     int operation1=0;

    //     Arrays.sort(nums);

    //     Stack<Integer> stack = new Stack<Integer>();

    //     for(int i=0; i<nums.length; i++)
    //     {
    //         if(!stack.contains(nums[i]))
    //         {
    //             stack.push(nums[i]);
    //         }

    //         else
    //         {
    //             operation1++;
    //         }
    //     }

    //     int index = randomWithRange(0,nums.length-1);
    //     int nums2[] = new int[nums.length];

    //     int operation2=0;

    //     for(int i=index; i<nums.length; i++)
    //     {
    //         nums2[i] = nums[index]+i;
    //     }

    //     for(int i=index-1; i>=0; i--)
    //     {
    //         nums2[i] = nums[index] -i;
    //     }

    //     for(int i=0; i<nums.length; i++)
    //     {
    //         int flag=0;

    //         for(int j=0; j<nums2.length; j++)
    //         {
    //             if(nums[i] == nums2[j])
    //             {
    //                 flag=1;
    //             }
    //         }

    //         if(flag == 0)
    //         {
    //             operation2++;
    //         }
    //     }



    //     return Math.max(operation1, operation2);
    // }

    // int randomWithRange(int min, int max){
        
    //     int range = (max - min) + 1;
        
    //     return (int)(Math. random() * range) + min;
    // }

    // public int minOperations(int[] nums){

    //     int operations=0;
    //     Arrays.sort(nums);

    //     Stack<Integer> stack = new Stack<Integer>();

    //     int nums2[] = new int[nums.length];

    //     for(int i=0; i<nums.length; i++)
    //     {
    //         nums2[i] = nums[0]+i;
    //     }

    //     for(int i=0 ; i<nums.length; i++)
    //     {
    //         int flag=0;
    //         for(int j=0; j<nums2.length; j++)
    //         {
    //             if(nums[i] == nums2[j])
    //             {
    //                 flag=1;
    //                 break;
    //             }
    //         }

    //         if(flag == 0)
    //         {
    //             operations++;
    //         }

    //         else if(!stack.contains(nums[i]))
    //         {
    //             stack.push(nums[i]);
    //         }
    //     }

    //     return Math.min(operations , (nums2.length - stack.size() ));

    // }


    // public int minOperations(int[] nums) {
        
    //     int operations=0;
    //     Arrays.sort(nums);

    //     int nums2[] = new int[nums.length];

    //     for(int i=0; i<nums.length; i++)
    //     {
    //         nums2[i] = nums[0]+i;
    //     }

    //     for(int i=0; i<nums.length; i++)
    //     {
    //         int flag=0;

    //         for(int j=0; j<nums2.length; j++)
    //         {
    //             if(nums[i] == nums2[j])
    //             {
    //                 flag=1;
    //             }
    //         }

    //         if(flag == 0)
    //         {
    //             operations++;
    //         }
    //     }

    //     return operations;
    // }
}