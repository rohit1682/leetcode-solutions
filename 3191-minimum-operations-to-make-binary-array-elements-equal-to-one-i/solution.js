/**
 * @param {number[]} nums
 * @return {number}
 */
var minOperations = function(nums) {
    let count = 0;
    for(let i = 0; i < nums.length-2; i++) {
        if(nums[i] === 0) {
            count++;
            nums[i] = 1;
            nums[i+1] = (nums[i+1]+1)%2;
            nums[i+2] = (nums[i+2]+1)%2;
        }
    }

    let sum = 0;
    for(let i=0; i <nums.length; i++) {
        sum += nums[i];
    }

    return (sum === nums.length) ? count : -1;
};