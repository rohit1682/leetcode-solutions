/**
 * @param {number} n
 * @return {boolean}
 */
var checkPowersOfThree = function(n) {
    let set = new Set();
    let helper = function(n) {
        if(n < 0 || n === 2) return false;
        let highest = 0;
        let pow = -1;
        for(let i=0; 3**i <= n; i++) {
            highest = 3**i;
            pow = i;
        }
        
        if(set.has(pow) === true || pow === -1) return false;
        else set.add(pow);

        if(n-highest === 0) return true;
        else return helper(n-highest);
    }
    
    return helper(n);

    // if(n < 0 || n == 2) return false;
    // let x=0;
    // for(let i=0; 3**i <= n; i++) {
    //     x = 3**i;
    // }
    // if(n-x === 0) return true;
    // else return checkPowersOfThree(n-x);
};