/**
 * @param {string} s1
 * @param {string} s2
 * @return {boolean}
 */
var areAlmostEqual = function(s1, s2) {
    if(s1.length !== s2.length) return false;
    let diff = 0;
    let index1 = 0, index2 = 0;
    for(let i=0; i<s1.length; i++) {
        if(s1.charAt(i) !== s2.charAt(i)) {
            diff++;
            if(diff === 1) index1 = i;
            if(diff === 2) index2 = i;
        }
    }
    if(diff > 2) return false;
    else if( (s1.charAt(index1) !== s2.charAt(index2)) || (s2.charAt(index1) !== s1.charAt(index2)) ) return false; 
    return true;
};