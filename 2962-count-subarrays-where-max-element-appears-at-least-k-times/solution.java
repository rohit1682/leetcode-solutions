
class Solution {
    public long countSubarrays(int[] nums, int k) {
        int mx = Arrays.stream(nums).max().getAsInt();
        long ans = 0;
        int l = 0,r=0,n=nums.length;
        
        while (r < n) {
            k -= nums[r] == mx ? 1 : 0;
            r++;
            while (k == 0) {
                k += nums[l] == mx ? 1 : 0;
                l++;
            }
            ans += l;
        }
        
        return ans;
    }
}


// class Solution {
//     public long countSubarrays(int[] nums, int k) {
//         int max = nums[0];
//         int countMax = 0;

//         for(int i : nums)
//         {
//             if(max <= i)
//             {
//                 max = i;
//                 countMax++;
//             }
//         }

//         if(countMax < k)
//         {
//             return 0;
//         }
//         else if (countMax == k)
//         {
//             return 1;
//         }

//         else
//         {
//             int count=check(nums, 0, 0, 0, k, max);

//             return count;
//         }

        
//     }

//     int check(int nums[], int count, int len, int pos, int k, int max)
//     {
//         if(pos+len >= nums.length)
//         {
//             return count;
//         }

//         int countMax = 0;
//         for(int i=pos; i<= len && i< nums.length; i++)
//         {
//             if(nums[i] == max)
//             {
//                 countMax++;
//             }
//         }

//         if(countMax == k)
//         {
//             count++;
//             pos++;
//         }
//         else
//         {
//             len++;
//         }

//         return check(nums, count, len, pos, k, max);
//     }
// }