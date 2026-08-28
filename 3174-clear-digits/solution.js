/**
 * @param {string} s
 * @return {string}
 */
var clearDigits = function(s) {
    let stack = [];
    for(let char of s) {
        if(char.charCodeAt(0) >= 48 && char.charCodeAt(0) <= 57 && stack.length !== 0) {
            stack.pop();
        }
        else stack.push(char);
    }
    
    return stack.join('');
};