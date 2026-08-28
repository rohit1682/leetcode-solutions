class Solution {
    public int findJudge(int n, int[][] trust) {
        if(n == 0) return -1;
        if(trust.length == 0 && n < 2) return 1;
        int freq[] = new int[n+1];
        for(int i=0; i<trust.length; i++) {
            freq[trust[i][1]]++;
            freq[trust[i][0]]--;
        }
        for(int i=0; i<freq.length; i++) {
            if(freq[i] == n-1){
                return i;
            }
        }
        return -1;
    }
}