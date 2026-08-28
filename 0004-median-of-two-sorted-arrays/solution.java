class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int arr[]=new int[m+n];
        int min;
        int max;
        if(m<=0)
        {
            min=nums2[0];
            max=nums2[0];
        }
        else if(n<=0)
        {
            min=nums1[0];
            max=nums1[0];
        }
        else
        {
            min=nums1[0];
            max=nums2[0];
        }

        for(int i=0;i<m;i++)
        {
            if(min>=nums1[i])
            {
                min=nums1[i];
            }
            if(max<=nums1[i])
            {
                max=nums1[i];
            }
        }
        for(int i=0;i<n;i++)
        {
            if(min>=nums2[i])
            {
                min=nums2[i];
            }
            if(max<=nums2[i])
            {
                max=nums2[i];
            }
        }
        int c=0;
        for(int i=min;i<=max;i++)
        {
            int a=m-1;
            int b=n-1;
            if(a<m)
            {
                while(a>=0)
                {
                    if(nums1[a]==i)
                    {
                        arr[c]=nums1[a];
                        c++;
                    }
                    a--;
                }
            }
            if(b<n)
            {
                while(b>=0)
                {
                    if(nums2[b]==i)
                    {
                        arr[c]=nums2[b];
                        c++;
                    }
                    b--;
                }
            }
            
           
        }
        int a,b;
        c=m+n;
        double result;
        if(c%2==0)
        {
            a=(c/2)-1;
            b=(c/2);
            result=(double)(arr[a]+arr[b])/2;
        }
        else
        {
            a=(c/2);
            result=(double)arr[a];
        }
        return result;
    }
}