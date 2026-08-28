/**
 * @param {string} s
 * @return {string}
 */
var longestPalindrome = function(s) {
   let startIndex = 0;
    let maxLength = 1;

    function expandAroundMiddle(left , right){
        while(left >= 0 && right < s.length && s[left] === s[right]){
            const currentPalLength = right - left + 1;
            if(currentPalLength > maxLength){
                maxLength = currentPalLength;
                startIndex = left;
            }
            left -=1;
            right +=1;
        }
    }

    for(let i = 0; i<s.length ; i++){
        expandAroundMiddle(i-1, i+1);
        expandAroundMiddle(i, i+1);
    }

    return s.slice(startIndex, startIndex + maxLength);
};

// this is a correct code
// var longestPalindrome = function(s) {
//     if(s.length <= 1) return s;

//     let maxLength = 1;
//     let maxString = s[0];
//     const dp = new Array(s.length);

//     for(let i=0; i<s.length; i++) {
//         dp[i] = new Array(s.length).fill(false);
//         dp[i][i] = true;
//         if (i < s.length-1 && s[i] === s[i+1]) {
//             dp[i][i+1] = true;
//             maxString = s.substring(i, i+2); 
//             maxLength = 2;
//         }
//     }

//     for (let length = 3; length <= s.length; length++) {
//         for (let i = 0; i <= s.length - length; i++) {
//             let j = i + length - 1;
//             if (s[i] === s[j] && dp[i+1][j-1]) {
//                 dp[i][j] = true;
//                 if (length > maxLength) {
//                     maxLength = length;
//                     maxString = s.substring(i, j + 1); 
//                 }
//             }
//         }
//     }

//     return maxString;
// };

    // for(let i=0; i<s.length; i++) {
    //     for(let j=i; j<s.length; j++) {
    //         let sub = s.substring(i,j);
    //         if(isPalindrome(sub)) {
    //             dp[i][j] = true;
    //             if(sub.length > maxLength) {
    //                 maxLength = sub.length;
    //                 maxString = sub;
    //             }
    //         }
    //     }
    // }


