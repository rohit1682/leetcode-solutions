/**
 * @param {string} s
 * @param {number} k
 * @return {number}
 */

var longestSubstring = function(s, k) {
    if (s.length < k || !s) return 0; // Simplified base cases

    return findLongest(s, k);
};

function findLongest(s, k) {
    const charMap = new Array(26).fill(0);
    for (let i = 0; i < s.length; i++) {
        charMap[s.charCodeAt(i) - 'a'.charCodeAt(0)]++;
    }
    
    // Check for valid full string
    let valid = true;
    for (let count of charMap) {
        if (count > 0 && count < k) {
            valid = false;
            break;
        }
    }
    if (valid) return s.length; // If all characters meet the condition k
    
    // If not, find the longest substring by splitting
    let maxLen = 0, start = 0;
    for (let i = 0; i < s.length; i++) {
        if (charMap[s.charCodeAt(i) - 'a'.charCodeAt(0)] < k) {
            maxLen = Math.max(maxLen, findLongest(s.substring(start, i), k));
            start = i + 1;
        }
    }
    maxLen = Math.max(maxLen, findLongest(s.substring(start), k)); // Check the remaining part
    
    return maxLen;
}

// var longestSubstring = function(s, k) {
//     if(s.length < k || !s) return 0;
//     let map = new Array(26).fill(0);
//     for(let i=0; i<s.length; i++) {
//         map[s.charCodeAt(i)-'a'.charCodeAt(0)]++;
//     } 
//     let result = 0;
//     for(let i=0; i<s.length; i++) {
//         let count = s.charCodeAt(i)-'a'.charCodeAt(0);
//         if(map[count] < k && count > 0) {
//             result = Math.max(longestSubstring(s.substring(0,i), k), longestSubstring(s.substring(i+1,s.length), k));
//             break;
//         }
//     }
//     if(result === 0) result = s.length;
//     return result;
// };
