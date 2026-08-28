/**
 * @param {number[]} nums
 * @return {number}
 */
var countPartitions = function(nums) {
    const odds = nums.reduce((acc, num) => {
        if(num%2 !== 0) acc++;
        return acc;
    }, 0);
    return (odds%2 === 0) ? nums.length-1 : 0;
};