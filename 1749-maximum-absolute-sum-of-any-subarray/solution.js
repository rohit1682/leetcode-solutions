/**
 * @param {number[]} nums
 * @return {number}
 */
var maxAbsoluteSum = function(nums) {
    if(nums.length === 0) return 0;
    if(nums.length === 1) return Math.abs(nums[0]);
    let max = nums[0];
    let min = nums[0];
    let sumMax = nums[0];
    let sumMin = nums[0];

    for(let i=1; i<nums.length; i++) {
        sumMax = Math.max(nums[i], sumMax+nums[i]);
        max = Math.max(max, sumMax);
        sumMin = Math.min(nums[i], sumMin+nums[i]);
        min = Math.min(min, sumMin);
    }
    min = Math.abs(min);
    max = Math.abs(max);
    return Math.max(max, min);
};