class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }
        Arrays.sort(freq);
        int chunk = freq[25] - 1;
        int idle = chunk * n;

        for (int i = 24; i >= 0; i--) {
            idle -= Math.min(chunk, freq[i]);
        }

        return idle < 0 ? tasks.length : tasks.length + idle;
    }
}

// class Solution {
//     public int leastInterval(char[] tasks, int n) {
        
//         boolean[] check = new boolean[tasks.length];
//         int[] ans = new int[tasks.length * n];

//         int count=0;

//         for(int i=0; i < tasks.length; i++)
//         {
//             check[i] = false;
//         }
        
//         if ((tasks.length == 0) || (tasks.length == 1))
//         {
//             return tasks.length;
//         }
//         else
//         {
//             int flag=0;
//             int curr=0;

//             while(true)
//             {
//                 int i;
//                 for(i=0; i < tasks.length; i++)
//                 {
//                     if(check[i] == false)
//                     {
//                         flag=1;
//                         break;
//                     }
//                 }
//                 if(flag==0)
//                 {
//                     break;
//                 }
//                 else
//                 {
//                     put(tasks, n, ans, check, i, curr);
//                     curr++;
//                     count++;
//                 }
//             }            
//         }

//         return count;
//     }

//     void put(int[] tasks, int n, int[] ans, 
//     boolean[] check, int i, int curr)
//     {
//         //put the elements
//         //and make that inder 'true'
//     }
// }