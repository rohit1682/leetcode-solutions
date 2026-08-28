class Solution {
    public String[] findRelativeRanks(int[] score) {
        int max = score[0];
        int min = score[0];

        for(int element : score) {
            if(max <= element) max = element;
            if(min >= element) min = element;
        }
        String[] ans = new String[score.length];
        int count = 0;
        for(int i=max; i>=min; i--) {
            for(int j=0; j<score.length; j++) {
                if(i == score[j]) {
                    if(count == 0) {
                        ans[j] = "Gold Medal";
                    }
                    else if(count == 1) {
                        ans[j] = "Silver Medal";
                    }
                    else if(count == 2) {
                        ans[j] = "Bronze Medal";
                    }
                    else {
                        ans[j] = Integer.toString((count+1));
                    }
                    count++;
                }
            }
        }
        return ans;
    }
}