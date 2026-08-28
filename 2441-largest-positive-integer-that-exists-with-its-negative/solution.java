class Solution {
    public int findMaxK(int[] nums) {
        Arrays.sort(nums);

        int i = nums.length-1;
        while((nums[i] >= 0) && (i > 0))
        {
            int j = 0;
            while(nums[j] <= 0)
            {
                if((nums[j])*(-1) == nums[i])
                {
                    return nums[i];
                }
                j++;
            }
            i--;
        }
        return -1;
    }
}