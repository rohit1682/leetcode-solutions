/**
 * @param {number[]} nums
 * @return {number}
 */
var countBadPairs = function(nums) {
    let myMap = new Map();
    let sum = 0;
    for(let i=0; i<nums.length; i++) {
        myMap.set(nums[i]-i, (myMap.get(nums[i]-i) || 0) + 1);
    }
    for(let [num, freq] of myMap) {
        if(freq > 1) sum += calculateNC2(freq);
    }
    return (calculateNC2(nums.length)-sum);
};

function calculateNC2(n) {
    if (n < 2) {
        return 0; 
    }
    return (n * (n - 1)) / 2;
}