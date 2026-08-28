/**
 * @param {number[]} nums
 * @return {boolean}
 */
var isArraySpecial = function(nums) {
    if(nums.length === 0) return true;
    let key = (nums[0]%2 === 0);
    for(let i=1; i<nums.length; i++) {
        if(key === (nums[i]%2 === 0)) return false;
        key = (nums[i]%2 === 0);
    }
    return true;
};