import java.util.*;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {

        return atMostKDistinct(nums, k) - atMostKDistinct(nums, k - 1);
    }
    
    private int atMostKDistinct(int[] nums, int k) {
        
        int[] frequency = new int[nums.length + 1]; 
        int left = 0, right = 0; 
        int distinct = 0; 
        int count = 0; 
        
        while (right < nums.length) {
            if (frequency[nums[right]] == 0) {
                distinct++;
            }
            frequency[nums[right]]++;
            right++;
            
            while (distinct > k) {
                frequency[nums[left]]--;
                if (frequency[nums[left]] == 0) {
                    distinct--;
                }
                left++;
            }
            
            count += right - left;
        }
        
        return count;
    }
}



// class Solution {
//     public int subarraysWithKDistinct(int[] nums, int k) {
//         if ( (k == 0) || (k >= nums.length) )
//         {
//             return 0;
//         }

//         Queue<Integer> queue = new LinkedList<>();

//         int right=0;
//         int count=0;
    
//         while(right < nums.length)
//         {
//             if(queue.contains(nums[right]))
//             {
//                 queue.offer(nums[right]);
//                 right++;
//             }
//             else
//             {
//                 k--;
//                 queue.offer(nums[right]);
//                 right++;
//             }

//             if(k == 0)
//             {
//                 count++;
//                 queue.remove();
//                 k++;
//             }
//         }

//         return count;

//     }
// }