class Solution {
    public boolean isPerfectSquare(int num) {
        if(((long)Math.sqrt(num))*((long)Math.sqrt(num))==num) return true;
        else return false;
    }
}