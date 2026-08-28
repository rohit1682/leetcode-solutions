class Solution {
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int maxFreq=0;int value=Integer.MAX_VALUE;
        for (int num : nums) {
            if (num % 2 == 0) {
                hm.put(num, hm.getOrDefault(num, 0) + 1);
                int currentFreq = hm.get(num);

                if(currentFreq> maxFreq|| currentFreq==maxFreq && num<value){
                    value=num;
                    maxFreq=currentFreq;
                }

            }
        }
        return maxFreq==0?-1:value;
    }
}

// 189/219
// class Solution {
//     public int mostFrequentEven(int[] nums) {
//         if(nums.length<=1 && nums[0]%2==0) return nums[0];
//         int max=-999;
//         for(int element : nums) {
//             if(max<=element) max = element;
//         }        
//         int[] arr = new int[max+1];
//         max=-1;
//         for(int element : nums) {
//             arr[element]++;
//             if(max<=arr[element]) max = arr[element];
//         }
//         // if(max == 1) return -1;
//         for(int i=0; i<arr.length; i++) {
//             if((max == arr[i])&&(i%2==0)) return i;
//         }
//         return -1;
//     }
// }