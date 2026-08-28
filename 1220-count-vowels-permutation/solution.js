/**
 * @param {number} n
 * @return {number}
 */
 

let mod = (10**9) + 7;
 
var countVowelPermutation = function(n) {
    if(n === 0) return 0;
   
    let dp = new Array(5);

    for(let i=0; i<5; i++) {
        dp[i] = new Array(n+1).fill(0);
    }

    let map1 = new Map([
        ["a", ["e"]],
        ["e", ["a", "i"]],
        ["i", ["a", "e", "o", "u"]],
        ["o", ["i", "u"]],
        ["u", ["a"]]
    ]);

    let map2 = new Map([
        ["a", 0],
        ["e", 1],
        ["i", 2],
        ["o", 3],
        ["u", 4]
    ]);
 
    let ans = 0;
 
    for(let key of map1.keys()) {
        ans = (ans + solve(map1, map2, dp, key, n))%mod;
    }
 
    return ans;
};
 
function solve(map1, map2, dp, currentAlpha, remLength) {
    if(remLength === 1) return 1;
    
    let index = map2.get(currentAlpha);
    if(dp[index][remLength] !== 0) return dp[index][remLength];
 
    let ans = 0;
    let vals = map1.get(currentAlpha);
    for(let element of vals) {
        ans = (ans + solve(map1, map2, dp, element, remLength-1))%mod;
    }
 
    dp[index][remLength] = ans;
    return dp[index][remLength];
}