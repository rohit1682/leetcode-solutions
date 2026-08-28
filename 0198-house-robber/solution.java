class Solution {
    public int rob(int[] nums) {
        int dp[]=new int[nums.length+1];
        dp[0]=0;
        dp[1]=nums[0];
        for(int i=1;i<nums.length+1;i++) {
            if(i==1) dp[i]=nums[0];
            else dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i-1]);
        }
        return dp[nums.length];      
    }
}