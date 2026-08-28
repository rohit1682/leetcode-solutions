/**
 * @param {string} word
 * @return {number}
 */

var possibleStringCount = function(word) {
    if(!word) return 0;
    let count = 1;
    for(let i=1; i<word.length; i++) {
        if(word[i] === word[i-1]) count++;
    }
    return count;
}

// var possibleStringCount = function(word) {
//     if(!word) return 0;
//     const myCache = new Array();
//     for(letter of word) {
//         if(myCache[myCache.length-1] !== letter)myCache.push(letter);
//     }
//     return word.length-myCache.length+1;
// };