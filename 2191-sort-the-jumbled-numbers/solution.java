class Solution {
  public int[] sortJumbled(int[] mapping, int[] nums) {
    var n = nums.length;
    var arr = new int[n][2];

    for (var i = 0; i < n; i++) {
      arr[i][0] = nums[i];
      
      if (nums[i] == 0)
        arr[i][1] = mapping[0];

      for (int j = nums[i], k = 1; j > 0; j /= 10, k *= 10)
        arr[i][1] += (mapping[j % 10] * k);
    }
    Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));

    for (var i = 0; i < n; i++)
      nums[i] = arr[i][0];

    return nums;
  }
}

// class Solution {
//     public int[] sortJumbled(int[] mapping, int[] nums) {
//         int[] map = new int[nums.length];
//         for(int i=0;i<nums.length;i++) {
//             map[i]=getNum(nums[i], mapping);
//         }
//     }

//     int getNum(int num, int[] mapping) {
//         if(num==0) return mapping[0];
//         int ans=0;
//         while(num!=0) {
//             ans=mapping[num%10]+(ans*10); 
//             num/=10;
//         }
//         return reverse(ans);
//     }

//     int reverse(int num) {
//         int ans=0;
//         while(num>0) {
//             ans=(ans*10)+num%10;
//             num/=10;
//         }
//         return ans;
//     }
// }
// }


// // class Solution {
// //     public int[] sortJumbled(int[] mapping, int[] nums) {
// //         int[] map = new int[nums.length];
// //         for(int i=0;i<nums.length;i++) {
// //             map[i]=getNum(nums[i], mapping);
// //         }

// //         Pair[] pairs = new Pair[map.length];
// //         for (int i = 0; i < map.length; i++) {
// //             pairs[i] = new Pair(map[i], nums[i]);
// //         }

// //         Arrays.sort(pairs, Comparator.comparingInt(p -> p.mapValue));

// //         for (int i = 0; i < pairs.length; i++) {
// //             map[i] = pairs[i].mapValue;
// //             nums[i] = pairs[i].numValue;
// //         }
// //         return nums;
// //     }

// //     int getNum(int num, int[] mapping) {
// //         if(num==0) return mapping[0];
// //         int ans=0;
// //         while(num!=0) {
// //             ans=mapping[num%10]+(ans*10); 
// //             num/=10;
// //         }
// //         return reverse(ans);
// //     }

// //     int reverse(int num) {
// //         int ans=0;
// //         while(num>0) {
// //             ans=(ans*10)+num%10;
// //             num/=10;
// //         }
// //         return ans;
// //     }
// // }

// // class Pair {
// //     int mapValue;
// //     int numValue;

// //     Pair(int mapValue, int numValue) {
// //         this.mapValue = mapValue;
// //         this.numValue = numValue;
// //     }
// // }