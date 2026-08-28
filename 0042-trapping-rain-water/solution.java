class Solution {
    public int trap(int[] height) {

        int i=0,left=height[0],sum=0;
        int j=height.length-1,right=height[j];

        while (i<j)
        {
            if(left <= right)
            {
                sum+=(left-height[i]);
                i++;
                left=Math.max(left,height[i]);
            }
            else 
            {
                sum+=(right-height[j]);
                j--;
                right=Math.max(right,height[j]);
            }
        }

        return sum;
        
    }
}