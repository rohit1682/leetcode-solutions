var findDifferentBinaryString = function(nums) {
    let result = [];
    for (let i = 0; i < nums.length; i++) {
        if (nums[i][i] === '0') {
            result.push('1');
        } else {
            result.push('0');
        }
    }
    return result.join('');
};