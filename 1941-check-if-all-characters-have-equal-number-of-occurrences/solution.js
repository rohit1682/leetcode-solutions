/**
 * @param {string} s
 * @return {boolean}
 */
var areOccurrencesEqual = function(s) {
    const charMap = new Map();
    for(let i=0; i<s.length; i++) {
        if(charMap.get(s.charAt(i)) === undefined) {
            charMap.set(s.charAt(i), 1);
        }
        else {
            charMap.set(s.charAt(i), (charMap.get(s.charAt(i)) + 1));
        }
    }

    let firstValue = null;

    for (const value of charMap.values()) {
        if (firstValue === null) {
            firstValue = value;
        } 
        else if (firstValue !== value) {
            return false;
        }
    }
    return true;
};