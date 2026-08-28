class Solution {
    public double averageWaitingTime(int[][] customers) {
        int currentTime=0;
        int[] wait = new int[customers.length];
        
        for(int i=0;i<customers.length;i++) {
            if(currentTime<customers[i][0]) currentTime+=(customers[i][0]-currentTime);
            currentTime+=customers[i][1];
            wait[i]=currentTime-customers[i][0];
        }
        double ans=0.0;
        for(int element : wait) {
            ans+=(double)element;
        }

        return (double)(ans/wait.length);

    }
}