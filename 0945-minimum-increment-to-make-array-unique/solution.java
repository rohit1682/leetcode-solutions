class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);

        int numTracker = 0; 
        int minIncrement = 0; 

        for (int num : nums) {
            numTracker = Math.max(numTracker, num);
            minIncrement += numTracker - num;
            numTracker += 1; 
        }

        return minIncrement;
    }
}

// class Solution {
//     public int minIncrementForUnique(int[] nums) {
//         Arrays.sort(nums);
//         Stack<Integer> stack = new Stack<Integer>();
//         int ans=0;
//         for(int i=0; i<nums.length; i++) {
//             while(true) {
//                 if(stack.search(nums[i]) != -1) {
//                     nums[i]++;
//                     ans++;
//                 }
//                 else break;
//             }
//             stack.push(nums[i]);
//         }
//         return ans;
//     }
// }