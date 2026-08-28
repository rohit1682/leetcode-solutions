class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        
        Arrays.sort(deck);
        int[] ans = new int[deck.length];

        return check(ans, deck, 0, 0, false);
        
    }

    int[] check(int[] ans, int[] deck, int x, int y, boolean willCheck)
    {
        if(x == deck.length)
        {
            return ans;
        }

        while(y < deck.length)
        {
            if(ans[y] == 0)
            {
                if(!willCheck)
                {
                    ans[y] = deck[x];
                    x++;
                }
                willCheck = !willCheck;
            }
            y++;
        }

        return check(ans, deck, x, 0, willCheck);
    }
}