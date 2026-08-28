class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int[] arr=new int[nums.length];
        Arrays.sort(nums);
        int n =nums.length;
        int even =0;
        int odd=n-1;
        for(int i =0;i<n;i++)
        {
            if(nums[i]%2==0)
            {
                arr[even]=nums[i];
                even++;
            }
            else
            {
                arr[odd]=nums[i];
                odd--;
            }
        }       
        return arr;
    }
}