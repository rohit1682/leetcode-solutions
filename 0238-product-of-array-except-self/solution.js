/**
 * @param {number[]} nums
 * @return {number[]}
 */
// var productExceptSelf = function(nums) {
//     const ans = new Array(nums.length).fill(1);
//     let prod = 1;

//     for(let i=0; i<nums.length; i++) {
//         prod *= nums[i];
//     }

//     for(let i=0; i<nums.length; i++) {
//         ans.push(prod/nums[i]);
//     }

//     return ans;
// };

var productExceptSelf = function(nums) {
    
    const ans = new Array(nums.length).fill(1);
    let prefix = 1;
    let suffix = 1;

    for (let i=0; i<nums.length; i++) {
        ans[i] = prefix;
        prefix *= nums[i];
    }
    for (let i=nums.length-1; i>=0; i--) {
        ans[i] *= suffix;
        suffix *= nums[i];
    }

    return ans;
};