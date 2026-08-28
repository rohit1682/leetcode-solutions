class Solution {
    public int maxProfit(int[] prices) {
        int min_price = prices[0];
        int maxprof = 0;

        for(int i=1;i<prices.length;i++){
            maxprof = Math.max(maxprof,prices[i]-min_price);
            min_price = Math.min(prices[i],min_price);
        }

        return maxprof;
    }
}

// class Solution {
//     public int maxProfit(int[] prices) {
        
//         int minIndx=0;
//         int min=prices[0];
//         int max=-1;
        
//         for(int i=0; i < prices.length; i++)
//         {
//             if(min >= prices[i])
//             {
//                 min = prices[i];
//                 minIndx = i;
//             }
//         }

//         if(minIndx == prices.length-1)
//         {
//             return 0;
//         }
//         else
//         {
//             for(int i=minIndx+1; i < prices.length; i++)
//             {
//                 if(max <= prices[i])
//                 {
//                     max = prices[i];
//                 }
//             }
//         }

//         return (max - min);
//     }
// }