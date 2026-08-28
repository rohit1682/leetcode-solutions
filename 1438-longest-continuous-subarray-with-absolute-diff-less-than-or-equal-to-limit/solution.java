class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int max = nums[0];
        int min = nums[0];
        
        int[] dp = new int[nums.length];
        dp[0] = 1;
        
        for (int i=1; i<nums.length; i++) {
            if (nums[i]> max)
                max = nums[i];
            if (nums[i]< min)
                min = nums[i];
            
            dp[i] = dp[i-1];
            if (max - min <= limit) {
                dp[i] += 1;
            } else {
                int[] val = subarraytillIElement(nums, i, limit);
                if (val[2] >= dp[i]) {
                    max = val[0];
                    min = val[1];
                    dp[i] = val[2];
                }
            }
        }
        return dp[nums.length -1];
    }
    
    private int[] subarraytillIElement(int[] nums, int end, int limit) {
        int i = end;
        int max = nums[end];
        int min = max;        
        int count = -1;
        
        while(i>=0 && max-min <= limit) {
            if (nums[i]>max) {
                max = nums[i];
            }
            if (nums[i]<min) {
                min = nums[i];
            }
            count++;
            i--;
        }
        return new int[]{max, min, count};
    }
}

// class Solution {
//     public int longestSubarray(int[] nums, int limit) {
//         if(nums.length<2&&limit>=0) return 1;
//         int[][] dp = new int[nums.length][nums.length];
//         int[] ans = new int[nums.length];
//         for(int i=0;i<nums.length-1;i++) {
//             dp[i][i]=0;
//             for(int j=i+1;j<nums.length;j++) {
//                 int val=Math.abs(nums[i]-nums[j]);
//                 if(dp[i][j-1]>=val) dp[i][j]=dp[i][j-1];
//                 else dp[i][j]=val;
//             }
//             int max=dp[i][i];
//             int freq=0;
//             for(int k=i;k<nums.length;k++) {
//                 if(dp[i][k]>limit) break;
//                 if(max>dp[i][k]&&max!=0) {
//                     max=dp[i][k];
//                     freq=0;
//                 }
//                 freq++;
//             }
//             ans[i]=freq;
//         }
//         return Arrays.stream(ans).max().getAsInt();
//     }
// }