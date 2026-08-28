// class Solution {
//     public int search(int[] nums, int target) {

//         int pivot = (int) Math.min(nums[0], nums.length-1);

//         return ( (int) Math.max( (binary_search(nums, 0, pivot-1, target)), 
//         (binary_search(nums, pivot, nums.length-1, target)) ) );
//     }

//     int binary_search(int nums[], int left, int right, int x)
//     {
//         if (right >= left && left <= nums.length - 1) {
 
//             int mid = (left+right) /2;
 
//             if (nums[mid] == x)
//                 return mid;
 
//             if (nums[mid] > x)
//                 return binary_search(nums, left, mid - 1, x);
 
//             return binary_search(nums, mid + 1, right, x);
//         }
        
//         return -1;
//     }
// }

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }
            
            // If the left half is sorted
            if (nums[left] <= nums[mid]) {
                // Check if the target is within the sorted left half
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } 
            // If the right half is sorted
            else {
                // Check if the target is within the sorted right half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        
        return -1;
    }
}
