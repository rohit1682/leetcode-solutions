public class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long res = 0;
        int n = happiness.length, j = 0;

        for (int i = n - 1; i >= n - k; --i) {
            happiness[i] = Math.max(happiness[i] - j++, 0);
            res += happiness[i];
        }

        return res;
    }
}
// 673/674 test case passed
// class Solution {
//     public long maximumHappinessSum(int[] happiness, int k) {
//         Arrays.sort(happiness);
//         int i = happiness.length - 1;
//         int count = 0;
//         long sum = 0;
//         while(k>0 && happiness[i]>0) {
//             sum += happiness[i--];
//             int j=i;
//             while(j>=0) happiness[j--] -= 1;
//             k--;
//             if(k == 0) break;
//         }
//         return sum;
//     }
// }