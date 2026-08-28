class Solution {
    public int findNonMinOrMax(int[] nums) {
        Arrays.sort(nums);
        if(nums.length==2 || nums.length==1 || nums.length==0)
        {
            return -1;
        }
        else
        {
            return nums[nums.length-2];
        }
    }
}