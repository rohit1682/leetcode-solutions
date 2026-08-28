public class Solution {
    public int smallestValue(int n) {
        if(n==1) return n;
        while(!isPrime(n)){
            int sum=0;
            int p=n;
            while(p%2==0){
                sum+=2;
                p=p/2;
            }
            for(int i=3;i*i<=n;i+=2){
                while(p%i==0){
                    sum+=i;
                    p=p/i;
                }
            } 
            if(p!=1) sum+=p;
            if(sum==n) return n;
            n=sum;
        }                                  
        return n;
    }
    boolean isPrime(int n){
        if(n==1) return false;
        for(int i=2;i*i<=n;i++) if(n%i==0) return false;
        return true;
    }
}

// class Solution {
//     public int smallestValue(int n) {
//         int ans=factorSum(n);
//         if(ans==n) return ans;
//         else return smallestValue(ans);
//         // if(isPrime(n)||n<8) return n;
//         // return smallestValue(factorSum(n));
//     }

//     int factorSum(int n) {
//         int sum=0;
//         int copy=n;
//         for(int i=2;i<=n/2;i++) {
//             if((copy%i==0)&&(isPrime(i))) {
//                 while(copy%i==0) {
//                     sum+=i;
//                     copy/=i;
//                 }
//             }
//         }
//         return sum;
//     }

//     boolean isPrime(int n) {
//         if(n<=1) return false;
//         for(int i=2;i<=n/2;i++) {
//             if(n%i==0) return false;
//         }
//         return true;
//     }
// }