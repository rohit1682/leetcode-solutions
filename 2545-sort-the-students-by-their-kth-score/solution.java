class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        int[][] ans = new int[score.length][score[0].length];
        for(int i=0;i<score.length;i++) {
            int index = maxRow(score,k);
            for(int j=0;j<score[0].length;j++) {
                ans[i][j]=score[index][j];
                score[index][j]=0;
            }
        }
        return ans;
    }
    int maxRow(int[][] score, int j) {
        int max=-1;
        int index=-1;
        for(int i=0;i<score.length;i++) {
            if(score[i][j]>max) {
                max=score[i][j];
                index=i;
            }
        }
        return index;
    }
}