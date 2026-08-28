class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        String[] ans = new String[names.length];
        int c=0;
        while(true) {
            int max=-1;
            int index=-1;
            for(int i=0;i<heights.length;i++) {
                if(max<=heights[i]) {
                    max = heights[i];
                    index = i;
                }
            }
            if(max==-1) break;
            else {
                ans[c++]=names[index];
                heights[index]=-1;
            }
        }     
        return ans;   
    }
}