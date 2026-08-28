/**
 * @param {number[]} nums
 * @return {number}
 */
var countNicePairs = function(nums) {
    const MOD = 1e9 + 7;
    let myMap = new Map();
    let sum = 0;
    
    for(let i = 0; i < nums.length; i++) {
        let diff = nums[i] - rev(nums[i]);
        if (myMap.has(diff)) {
            sum = (sum + myMap.get(diff)) % MOD;
        }
        myMap.set(diff, (myMap.get(diff) || 0) + 1);
    }

    return sum;
};

function rev(num) {
    return parseInt(num.toString().split('').reverse().join(''));
}

// var countNicePairs = function(nums) {
//     let myMap = new Map();
//     let sum = 0;
//     for(let i=0; i<nums.length; i++) {
//         myMap.set(nums[i]-rev(nums[i]), (myMap.get(nums[i]-rev(nums[i])) || 0) + 1);
//     }
//     for(let [num, freq] of myMap) {
//         if(freq > 1) sum += calculateNC2(freq);
//     }
//     return sum;
// };

// function rev(num) {
//     let reversed = parseInt(num.toString().split('').reverse().join ('')) * Math.sign(num);
//     return reversed;
// }

// function calculateNC2(n) {
//     if (n < 2) {
//         return 0; 
//     }
//     return (n * (n - 1)) / 2;
// }