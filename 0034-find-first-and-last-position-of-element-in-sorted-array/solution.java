class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int arr[] = new int[2];
        int flag=0;

        for(int i=0; i<nums.length; i++)
        {
            if(target == nums[i])
            {
                arr[0] = i;
                flag=1;
                break;
            }
        }

        if(flag == 0)
        {
            arr[0] = -1;
            arr[1] = -1;
        }

        else
        {
            for(int i=nums.length-1; i>=0; i--)
            {
                if(target == nums[i])
                {
                    arr[1] = i;
                    break;
                }
            }
        }

        return arr;
    }
}