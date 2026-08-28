class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int count = 0;

        for(int i=0; i<nums.length; i++) {
            sum += nums[i];
            
            int rem = sum - goal;
            if(map.containsKey(rem)) {
                count += map.get(rem);
            }

            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return count;
    }
    
    // public int numSubarraysWithSum(int[] nums, int goal) {
    //     int count=0;
    //     for (int i=0; i < nums.length; i++)
    //     {
    //         for (int j=nums.length; j>i; j--)
    //         {
    //             int[] subArray = Arrays.copyOfRange(nums, i, j);

    //             if(check(subArray, goal))
    //             {
    //                 count++;
    //             }
    //         }
    //     }
    //     return count;
    // }

    // boolean check(int[] subArray, int goal)
    // {
    //     int sum=0;
    //     for(int i=0; i<subArray.length; i++)
    //     {
    //         sum+=subArray[i];
    //     }

    //     if(sum == goal)
    //     {
    //         return true;
    //     }
    //     else
    //     {
    //         return false;
    //     }
    // }
}