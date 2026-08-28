class Solution {
    public int[] numberOfPairs(int[] nums) {
        int[] temp=new int[101];
        int[] result=new int[2];
        int pairs=0,leftOver=0;
 
        for(int i: nums)
        {
            temp[i]++;
        }

        for(int i: temp)
        {
               if(i>0)
               {
                   pairs=pairs+(i/2);
                   leftOver=leftOver+(i%2);
               }
        }
        result[0]=pairs;
        result[1]=leftOver;
        return  result;
    }
}