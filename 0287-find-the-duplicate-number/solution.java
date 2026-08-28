class Solution {
    public int findDuplicate(int[] nums) {
        
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        fast = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}

// class Solution {
//     public int findDuplicate(int[] nums) {
//         int sptr=0;
//         int fptr=0;

//         while(nums[sptr] != nums[fptr])
//         {
//             if( (nums[sptr] == nums[fptr]) && (sptr != fptr) )
//             {
//                 break;
//             }
            
//             sptr = (int)((sptr+1) % nums.length);
//             fptr = (int)((fptr+2) % nums.length);

//         }

//         return nums[sptr];
//     }
// }

// class Solution {
//     public int findDuplicate(int[] nums) {
//         int sum1=0;
//         int sum2=0;
//         for(int i=0; i <nums.length; i++)
//         {
//             sum1+=i;
//             sum2+=nums[i];
//         }

//         return (sum2-sum1);
//     }
// }

