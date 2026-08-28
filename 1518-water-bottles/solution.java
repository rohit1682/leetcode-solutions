class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int sum=numBottles;
        int fresh,remaining;
        while(numBottles>=numExchange) {
            fresh=numBottles/numExchange;
            remaining=numBottles%numExchange;
            sum+=fresh;
            numBottles=fresh+remaining;
        }
        return sum;
    }
}