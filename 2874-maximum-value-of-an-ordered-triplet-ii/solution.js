/**
 * @param {number[]} nums
 * @return {number}
 */
var maximumTripletValue = function(nums) {
    let prefix_max = nums[0];
    let max_diff = 0;
    let res = 0;

    for (let k = 1; k < nums.length; k++){
        res = Math.max(res, max_diff * nums[k]);
        prefix_max = Math.max(prefix_max, nums[k]);
        max_diff = Math.max(max_diff, prefix_max - nums[k]);
    }
    return res;
};