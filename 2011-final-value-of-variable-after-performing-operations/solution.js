/**
 * @param {string[]} operations
 * @return {number}
 */
var finalValueAfterOperations = function(operations) {
    let ans = 0;
    for(exp of operations) {
        if(exp.charAt(1) === '+') ans+=1;
        else ans-=1;
    }
    return ans;
};