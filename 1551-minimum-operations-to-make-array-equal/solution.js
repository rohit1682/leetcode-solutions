/**
 * @param {number} n
 * @return {number}
 */
var minOperations = function(n) {
    let ans = 0;
    let target = 0;
    let i=0;

    for(i=0; i<n; i++) {
        target += (2*i)+1;
    }
    target = Math.floor(target/n);
    i=0;
    while((2*i)+1 < target) {
        ans += target-((2*i)+1); 
        i++;
    }
    return ans;
};