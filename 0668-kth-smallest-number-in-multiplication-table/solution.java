class Solution {
    public int findKthNumber(int m, int n, int k) {
        if (m > n) { 
            int t = n;
            n = m;
            m = t;
        }
        int low = Math.min(1, (k-1)/n), high = m*n; 
        while(low<=high) {
            int mid = (low+high)/2;
            if(!isEnough(m, n, k, mid)) {
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return low;
    }

    private boolean isEnough(int m, int n, int k, int curr) {
        int count = 0;
        int i = curr/n;
        count = i*n;
        i++;
        for(;i<=m;i++) {
            count += Math.min(curr/i, n);
        }
        return count>=k;
    }
}

// class Solution {
//     public int findKthNumber(int m, int n, int k) {
//         int lo=0, hi=m*n;
//         while (lo < hi){
//             int mid=(lo+hi)/2, count=0;
//             for (int i=1; i<=m; i++) count += n < mid/i ? n : mid/i;
//             if (count >= k)  hi = mid;
//             else  lo = mid+1;
//         }
//         return lo;
//     }
// }