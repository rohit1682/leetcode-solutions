class Solution {
    public int passThePillow(int n, int time) {
        int bits = time / (n - 1);
        
        if(bits % 2 == 0) return (time % (n - 1) + 1);
        else return (n - time % (n - 1));
    }
}