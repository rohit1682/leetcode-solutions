/**
 * @param {string} s
 * @return {number}
 */

var lengthOfLongestSubstring = function(s) {
    if(s.length == 0) return 0;

    let max = 0;
    let arr = [];
    
    for(let i = 0; i < s.length; i++) {
        let index = arr.indexOf(s.charAt(i));
        
        if(index !== -1) {
            arr = arr.slice(index + 1);
        }
        
        arr.push(s.charAt(i));
        max = Math.max(max, arr.length); 
    }
    return max;
};