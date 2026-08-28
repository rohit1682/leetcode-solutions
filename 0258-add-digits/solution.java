class Solution {
    public int addDigits(int num) {
        if(num<=9) return num;
        int ans=0;
        while(num>=1) {
            ans+=(num%10);
            num/=10;
        }
        return addDigits(ans);
    }
}