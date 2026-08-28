/**
 * @param {number[]} nums
 * @return {boolean}
 */
var check = function(nums) {
    if(nums.length < 2) return true;
    let count = 0;
    for(let i = 1; i <= nums.length; i++) {
        let curr = nums[i % nums.length];
        let prev = nums[(i - 1) % nums.length];
        if(prev > curr) {
            count++;
            if(count > 1) return false;
        }
    }
    return true;
};