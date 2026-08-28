/**
 * @param {number[]} nums
 * @return {number}
 */
var maxAscendingSum = function(nums) {
    if(nums.length == 0) return 0;
    let max = 0;
    let sum = nums[0];
    for(let i=1; i<nums.length; i++) {
        max = Math.max(max, sum);
        if(nums[i] <= nums[i-1]) sum = 0;
        sum += nums[i];
    }
    return Math.max(max, sum);
};