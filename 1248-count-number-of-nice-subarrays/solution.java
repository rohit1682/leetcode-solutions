class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        LinkedList<Integer> deq = new LinkedList();
        deq.add(-1);
        int res = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] % 2 == 1) 
                deq.add(i);
            if (deq.size() > k + 1) 
                deq.pop();
            if (deq.size() == k + 1) 
                res += deq.get(1) - deq.get(0);
        }
        return res;
    }
}

// 26/48
// class Solution {
//     public int numberOfSubarrays(int[] nums, int k) {
//         if(k>nums.length||k==0) return 0;
//         for(int i=0;i<nums.length;i++) {
//             if(nums[i]%2==0) nums[i]=0;
//             else nums[i]=1;
//         }
//         int ans=0;
//         for(int i=0;i<nums.length-k+1;i++) {
//             int copy=k;
//             for(int j=i;j<nums.length;j++) {
//                 if(copy==-1) break;
//                 if(nums[j]==1) copy--;
//                 if(copy==0) ans++;
//             }
//         }
//         return ans;
//     }
// }