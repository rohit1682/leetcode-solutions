class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        // int res[] = new int[m+n];

        // for(int i=0; i<m ;i++)
        // {
        //     res[i] = nums1[i];
        // }

        // for(int i=0; i<n ;i++)
        // {
        //     res[m+i] = nums2[i];
        // }

        // Arrays.sort(res);

        // for(int i=0 ; i<(m+n); i++)
        // {
        //     nums1[i]= res[i];
        // }

        for(int i=0; i<n; i++)
        {
            nums1[m+i] = nums2[i];
        }

        Arrays.sort(nums1);
    }
}