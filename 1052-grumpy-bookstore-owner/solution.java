class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int min=0;
        int index=0;
        for(int i=0;i<customers.length;i++) {
            if(grumpy[i]==0) {
                min+=customers[i];
                customers[i]=0;
            }
            if(customers[index]<customers[i]) {
                index=i;
            }
        }
        int loss = 0 ;
        for(int i = 0 ; i < minutes ; i++){
            if(grumpy[i] == 1){
                loss = loss + customers[i];
            }
        }
        int maxloss = loss;
        int i = 0;
        int j = minutes;
        while(j<customers.length){
            if(grumpy[i] == 1){
                loss = loss - customers[i];
            }
            if(grumpy[j] == 1){
                loss = loss + customers[j];
            }
            maxloss = Math.max(loss , maxloss);
            i++;
            j++;
        }
        return (min+maxloss);
    }
}