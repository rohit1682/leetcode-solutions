/**
 * @param {string} pattern
 * @return {string}
 */

var smallestNumber = function(pattern) {
    let result = [];
    let num = 1;
    let stack = [];

    for (let i = 0; i <= pattern.length; i++) {
        stack.push(num++); 

        if (i == pattern.length || pattern[i] == 'I') {
            while (stack.length) {
                result.push(stack.pop());
            }
        }
    }

    return result.join('');
};

// let replace = function(original, start, end) {
//     let before = original.slice(0, start);  
//     let after = original.slice(end+1);  
//     let replacement = original.slice(start, end+1);

//     replacement = replacement.split('').reverse().join('');

//     return before + replacement + after;
// }

// var smallestNumber = function(pattern) {
//     pattern = pattern.concat('I');
//     let ans = "";
//     for(let i=0; i<pattern.length; i++) {
//         ans += (i+1).toString();
//     }
    
//     let start = -1;
//     for(let i=0; i<pattern.length; i++) {
//         if(pattern[i] === 'D') {
//             if(start === -1) start = i;
//         }
//         if(pattern[i] === 'I' && start !== -1) {
//             ans = replace(ans , start, i-1);
//             start = -1;
//         }
//     }

//     return ans;
// };