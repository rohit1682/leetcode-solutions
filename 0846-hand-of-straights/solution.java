class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0)
            return false;
        
        Arrays.sort(hand);
        HashMap<Integer , Integer> countMap = new HashMap<>();
        for(int i = 0 ; i < hand.length ; i++)
            countMap.put(hand[i] , countMap.getOrDefault(hand[i] , 0) + 1);
        
        for(int i = 0 ; i < hand.length ; i++)
        {
            if(countMap.get(hand[i]) <= 0)
                continue;
            for(int j = 0 ; j < groupSize ; j++)
            {
                int currentCard = hand[i] + j;
                if(countMap.getOrDefault(currentCard , 0) == 0)  //as it may happen that currentCard may not be in the map thus we have to use the getOrDefault method 
                    return false;
                countMap.put(currentCard , countMap.get(currentCard) - 1);
            }
        }
        return true;
    }
}