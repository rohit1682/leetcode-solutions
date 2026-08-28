class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
       int maxCapital = 0;
        for(int i = 0 ; i < capital.length ; i++){
            maxCapital = Math.max(capital[i] , maxCapital);
        }
        
        if(w >= maxCapital){
            PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
                @Override
                public int compare(Integer a, Integer b) {
                    return a - b;
                }
            });
            for(int p : profits){
                maxHeap.add(p);
                if(maxHeap.size()>k)  maxHeap.poll();
            }
            for(int h: maxHeap) w+=h;
            return w;
        }
        
        
        int index ; 
        int n = profits.length;
        for(int i = 0 ; i < Math.min(k , n) ; i++){
            index = -1;
            for(int j = 0 ; j<n ; ++j){
                 if (w >= capital[j] && (index == -1 || profits[index] < profits[j])){
                     index = j;
                 }
            }
            if(index==-1) break;
            w+=profits[index];
            capital[index] = Integer.MAX_VALUE;
        }
        return w;
    }
}

// greedy 32/25
// class Solution {
//     public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
//         int index=-1; 
//         int maxProfit=-1;
//         while(k>0) {
//             for(int i=0;i<capital.length;i++) {
//                 if((capital[i]!=-1)&&(w>=capital[i])&&(maxProfit<profits[i])) {
//                     index = i;
//                     maxProfit = profits[i];
//                 }
//             }
//             if(index==-1) break;
//             w+=maxProfit;
//             capital[index]=-1;
//             profits[index]=0;
//             maxProfit=-1;
//             index=-1;
//             k--;
//         }
//         return w;
//     }
// }

// greedy knapsach not working
// class Solution {
//     public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
//         int[] perunit = new int[profits.length];
//         for(int i=0;i<profits.length;i++) {
//             try {
//                 perunit[i] = (int)profits[i]/capital[i];
//             }
//             catch(Exception e) {
//                 perunit[i] = 0;
//             }
//         }
//         for (int i = 1; i < perunit.length; ++i) {
//             int key = perunit[i];
//             int j = i - 1;
//             while (j >= 0 && perunit[j] > perunit[i]) {
//                 perunit[j + 1] = perunit[j];
                
//                 int temp = profits[j+1];
//                 profits[j+1] = profits[j];
//                 profits[j]=temp;
                
//                 temp = capital[j+1];
//                 capital[j+1] = capital[j];
//                 capital[j]=temp;
                
//                 j = j - 1;
//             }
//             perunit[j + 1] = key;
//         }
//         boolean[] check = new boolean[perunit.length];
//         Arrays.fill(check, false);
//         while(k>0) {
//             for(int i=perunit.length-1;i>=0;i--) {
//                 if((w>=capital[i])&&(check[i]==false)) {
//                     w+=profits[i];
//                     check[i] = true;
//                 }
//             }
//             k--;
//         }
//         return w;
//     }
// }