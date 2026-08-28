/**
 * @param {number[]} nums
 * @return {number[]}
 */
var constructTransformedArray = function(nums) {
    const n = nums.length;
    let result = new Array(n);
    for (let i = 0; i < n; i++) {
        const num = nums[i];
        if (num === 0) {
            result[i] = 0;
        } else {
            const index = ((i + num) % n + n) % n;
            result[i] = nums[index];
        }
    }
    return result;
};