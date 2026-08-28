/**
 * @param {number[]} nums
 * @return {number}
 */
var maxProduct = function(nums) {
    if(nums.length === 0) return 0;

    let max = nums[0];
    let min = nums[0]; 
    let prod = nums[0];

    for(let i=1; i<nums.length; i++) {
        let temp = Math.max(nums[i], prod*nums[i], min*nums[i]);
        min = Math.min(nums[i], prod*nums[i], min*nums[i]);
        prod = temp;
        max = Math.max(max, prod);
    }
    return max;
};