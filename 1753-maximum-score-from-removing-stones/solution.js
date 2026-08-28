/**
 * @param {number} a
 * @param {number} b
 * @param {number} c
 * @return {number}
 */
var maximumScore = function(a, b, c) {
    if((a === 0 && b === 0) || (b === 0 && c === 0) || (c === 0 && a === 0)) return 0;
    else {
        const min = Math.min(a,b,c);
        if(a === min) {
            return 1 + maximumScore(a, b-1, c-1);
        }        
        else if(b === min) {
            return 1 + maximumScore(a-1, b, c-1);
        }
        else {
            return 1 + maximumScore(a-1, b-1, c);
        }
    }
};