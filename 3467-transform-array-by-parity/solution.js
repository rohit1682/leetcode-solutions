/**
 * @param {number[]} nums
 * @return {number[]}
 */
var transformArray = function(nums) {
    return nums.map((num) => {
        return num%2;
    }).sort();
};