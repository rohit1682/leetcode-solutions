import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] nums) {
        int maxLength = 0;
        int count = 0;
        HashMap<Integer,Integer> countMap=new HashMap<>();
        countMap.put(0, -1);
        for (int i = 0; i < nums.length;i++) {
            count+=nums[i]==1?1:-1;
            if (countMap.containsKey(count)) {
                maxLength = Math.max(maxLength,i-countMap.get(count));
            } else {
                countMap.put(count,i);
            }
        }
        
        return maxLength;
    }
}

// class Solution {
//     public int findMaxLength(int[] nums) {
        
//         int max=0;

//         for (int i=0; i < nums.length; i++)
//         {
//             for(int j=nums.length-1-i; j > 0; j--)
//             {
//                 int subarr[] = Arrays.copyOfRange(nums, i, j);

//                 int res = check(nums);

//                 if((res != (-1)) && (max < res))
//                 {
//                     max = res;
//                 }
//             }
//         }

//         return max;
//     }

//     int check(int[] subarr)
//     {
//         int sum=0;

//         for (int i=0; i < subarr.length; i++)
//         {
//             if(subarr[i] == 0)
//             {
//                 sum--;
//             }
//             else
//             {
//                 sum++;
//             }
//         }

//         if(sum == 0)
//         {
//             return subarr.length;
//         }

//         else
//         {
//             return -1;
//         }
//     }
// }