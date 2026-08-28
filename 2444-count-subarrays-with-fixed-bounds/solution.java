class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long ans = 0;
        int c = -1, left = -1, right = -1;

        for (int i = 0; i < nums.length; ++i) {
            if (!(minK <= nums[i] && nums[i] <= maxK)) {
                c = i;
            }

            if (nums[i] == minK) {
                left = i;
            }

            if (nums[i] == maxK) {
                right = i;
            }

            ans += Math.max(0, Math.min(left, right) - c);
        }

        return ans;
    }
}

// class Solution {
//     public long countSubarrays(int[] nums, int minK, int maxK) {
        
//         if( (Arrays.asList(nums).contains(minK)) || 
//         (Arrays.asList(nums).contains(maxK)) )
//         {
//             return 0;
//         }

//         int count=0;
//         int left=0;
//         int right=0;
//         while( (right>=left) && (right < nums.length) )
//         {
//             if(nums[right] > maxK)
//             {
//                 left = right+1;
//                 right = right+1;
//             }

//             if(nums[left] < minK)
//             {
//                 left = left+1;
//                 right = left+1;
//             }

//             if(nums[left] >= minK)
//             {
//                 left++;
//             }

//             if(nums[right] <= maxK)
//             {
//                 right++;
//             }

//             int flag1=0;
//             int flag2=0;

//             for(int i=left; i<=right; i++)
//             {
//                 if(nums[i] == minK)
//                 {
//                     flag1=1;
//                 }
//                 if(nums[i] == maxK)
//                 {
//                     flag2=1;
//                 }
//             }

//             if( (flag1 == 1) && (flag2 == 1))
//             {
//                 count++;
//                 left++;
//             }

//         }

//         return count;
//     }
// }