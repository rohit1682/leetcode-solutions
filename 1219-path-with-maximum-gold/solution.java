class Solution {
    int ans=0,r,c;
    public int getMaximumGold(int[][] grid) {
        r=grid.length;
        c=grid[0].length;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]!=0){
                    helper(grid,i,j,grid[i][j]); 
                }
            }
        }
        return ans;
    }
    void helper(int[][] grid,int i,int j,int sum){
        if(sum>ans){
            ans=sum;
        }
        int temp=grid[i][j];
        grid[i][j]=0; 
        if(i>0 && grid[i-1][j]!=0){
            helper(grid,i-1,j,sum+grid[i-1][j]);
        }
        if(i<r-1 && grid[i+1][j]!=0){
            helper(grid,i+1,j,sum+grid[i+1][j]);
        }
        if(j>0 && grid[i][j-1]!=0){
            helper(grid,i,j-1,sum+grid[i][j-1]);
        }
        if(j<c-1 && grid[i][j+1]!=0){
            helper(grid,i,j+1,sum+grid[i][j+1]);
        }
        grid[i][j]=temp;
    }
}