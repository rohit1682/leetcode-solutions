class Solution {
    public int minKBitFlips(int[] nums, int k) {
        if(k>nums.length) return -1;
        int ans=0, flip=0;
        int[] store = new int[nums.length];
        for(int i=0;i<nums.length;++i) {
            if (i >= k)
                flip ^= store[i - k];
            if (flip == nums[i]) {
                if (i + k > nums.length)
                    return -1;
                store[i] = 1;
                flip ^= 1;
                ans++;
            }
        }
        return ans;
    }
}