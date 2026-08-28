/**
 * @param {number[]} nums
 * @return {number}
 */
var maximumTripletValue = function(nums) {
        let maxx = 0;
        let minn = Infinity;
        let ans = 0;
        let maxVal = -1;
        let res = 0;

        for (let i = 0; i < nums.length - 1; i++) {
            if (nums[i] > maxx) {
                maxx = nums[i];
                minn = nums[i];
            }
            minn = Math.min(minn, nums[i]);
            if (ans < (maxx - minn)) {
                maxVal = maxx;
                ans = maxx - minn;
            }
            res = Math.max(res, ans * nums[i + 1]);
        }
        return res;  
};
