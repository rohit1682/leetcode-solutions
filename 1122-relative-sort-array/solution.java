class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] ans = new int[arr1.length];
        int c=0;
        for(int i=0;i<arr2.length;i++) {
            for(int j=0; j<arr1.length; j++) {
                if(arr1[j] == arr2[i]) {
                    ans[c++]=arr1[j];
                    arr1[j]=-999;
                }
            }
        }
        Arrays.sort(arr1);
        while(c<arr1.length) {
            ans[c]= arr1[c];
            c++;
        }
        return ans;
    }
}