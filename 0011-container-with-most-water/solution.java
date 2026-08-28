class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, currentArea);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}

// class Solution {
//     public int maxArea(int[] height) {

//         int max = Arrays.stream(height).max().getAsInt();
//         int countMax = 0;

//         for(int i : height)
//         {
//             if(i == max)
//             {
//                 countMax++;
//             }
//         }

//         int max2 = height[0];

//         for(int i : height)
//         {
//             if( (max2 <= i) && (i != max) )
//             {
//                 max2 = i;
//             }
//         }

//         return (max2*max2);

//         // if(countMax>=2)
//         // {
//         //     return (max*max);
//         // }
//         // else
//         // {
//         //     int max2 = height[0];

//         //     for(int i : height)
//         //     {
//         //         if( (max2 >= i) && (i != max) )
//         //         {
//         //             max2 = i;
//         //         }
//         //     }
//         //     return (max2*max2);

//         // }
//     }
// }

// class Solution {
//     public int maxArea(int[] height) {
        
//         Arrays.sort(height); 
//         //Arrays.reverse(height);

//         int i=0;
//         while(height[i] == height[0])
//         {
//             i++;
//         }

//         return (height[0] * height[i]);

//     }
// }

// class Solution {
//     public int maxArea(int[] height) {
//         int maxProduct=1;
//         for(int i=0; i<height.length; i++)
//         {
//             for(int j=i; j<height.length; j++)
//             {
//                 if(i==j)
//                 {
//                     continue;
//                 }

//                 else
//                 {
//                     int num= Math.min(height[i], height[j]);
//                     int product= (num*num);
                    
//                     if(maxProduct <= product)
//                     {
//                         maxProduct= product;
//                     }
//                 }
//             }
//         }
//         return maxProduct;
//     }
// }