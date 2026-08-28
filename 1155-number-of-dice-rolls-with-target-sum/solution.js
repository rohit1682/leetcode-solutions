/**
 * @param {number} n
 * @param {number} k
 * @param {number} target
 * @return {number}
 */

var numRollsToTarget = function(n, k, target) {
    let dp = new Array(n);    
    for(let i=0; i<n+1; i++) {
        dp[i] = new Array(target + 1).fill(-1);
    }
    return solve(dp,0,target,n,k);
};

function solve(dp, currentDice, remTarget, n, k) {
    if (currentDice === n) {
        return remTarget === 0 ? 1 : 0;
    }
    if(dp[currentDice][remTarget] !== -1) return dp[currentDice][remTarget];

    let mod = (10**9) + 7;
    let ans = 0;
    for(let face = 1; face<=k; face++) {
        if(remTarget - face >= 0) ans += solve(dp, currentDice+1, remTarget - face, n, k);
        ans %= mod;
    }

    dp[currentDice][remTarget]=ans;
    return dp[currentDice][remTarget];
}


