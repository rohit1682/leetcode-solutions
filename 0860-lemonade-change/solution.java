class Solution {
    public boolean lemonadeChange(int[] bills) {
        if(bills[0] != 5) return false;

        int have[] = new int[3];
        Arrays.fill(have, 0);
        for(int i=0; i<bills.length; i++)
        {
            if(bills[i] == 5)
            {
                have[0]++;
            }
            else if(bills[i] == 10)
            {
                if(have[0] >= 1){
                    have[0]--;
                }
                else{
                    return false;
                }
                have[1]++;
            }
            else {
                if((have[0] >= 1) && (have[1] >=1))
                {
                    have[0]--;
                    have[1]--;
                }
                else {
                    if(have[0] >= 3) {
                        have[0] -= 3;
                    }
                    else {
                        return false;
                    }
                }
                have[2]++;
            }
        }
        return true;
    }
}