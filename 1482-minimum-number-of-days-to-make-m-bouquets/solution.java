class Solution {
    static boolean isbest(int[] arr,int m,int k,int mid) {
		int b=0;
		int f=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]<=mid) {
				f++;
				if(f==k) {
					b++;
					if(b==m) {
						return true;
					}
					f=0;
				}
			}
			else {
				f=0;
			}
		}
		return false;
	}
    public int minDays(int[] arr, int m, int k) {
        if(m*k > arr.length) {
			return -1;
		}
		int l=arr[0],h=arr[0],mid;
		for (int i=0;i<arr.length;i++) {
			if(arr[i]<l) {
				l=arr[i];
			}
			if(arr[i]>h) {
				h=arr[i];
			}
		}
		int min=-1;
		while(l<=h) {
			mid=(l+h)/2;
			if(isbest(arr,m,k,mid)==true) {
				min=mid;
				h=mid-1;
			}
			else {
				l=mid+1;
			}
		}
		return min;
	}
}