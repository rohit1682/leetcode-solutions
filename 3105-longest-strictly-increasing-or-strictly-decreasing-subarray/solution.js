/**
 * @param {number[]} nums
 * @return {number}
 */
var longestMonotonicSubarray = function(nums) {
    if(nums.length == 0) return 0;
    
    let increase = 1;
    let decrease = 1;
    let max = 1;

    for(let i=1; i<nums.length; i++) {
        if(nums[i] > nums[i-1]) {
            increase++;
            decrease = 1;
        }

        else if(nums[i] < nums[i-1]) {
            decrease++;
            increase = 1;
        }

        else increase = decrease = 1;

        max = Math.max(max, increase, decrease);
    }

    return max;
};