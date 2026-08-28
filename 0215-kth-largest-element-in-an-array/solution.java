class Solution {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        int count=1;
        for(int i =nums.length-2;i>=0;i--)
        {
           
                count++;
            if(count==k)
            {
                return nums[i];
            }
        }

        return nums[nums.length-1];
    }
}