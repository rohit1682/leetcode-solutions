var getLucky = function(s, k) {
    const transform = function(t) {
        let res = 0;
        while (t > 0) {
            res += t % 10;
            t = Math.floor(t / 10);
        }
        return res;
    };
    
    
    let res = 0;
    for (let ch of s) {
        let num = ch.charCodeAt(0) - 'a'.charCodeAt(0) + 1;
        if (num >= 10) {
            res += num % 10 + Math.floor(num / 10);
        } else {
            res += num;
        }
    }

    // Perform the transformation k-1 times
    while (--k > 0) {
        res = transform(res);
    }

    // Return the final result after k transformations
    return res;
};

// /**
//  * @param {string} s
//  * @param {number} k
//  * @return {number}
//  */
// var sumOfDigits = function(sum) {
//     let ans = 0;
//     while(sum != 0) {
//         ans += sum%10;
//         // sum /= 10;
//         sum = Math.floor(sum / 10);
//     }
//     return ans;
// }

// var getLucky = function(s, k) {
//     const charMap = new Map([
//         ['a', "1"],
//         ['b', "2"],
//         ['c', "3"],
//         ['d', "4"],
//         ['e', "5"],
//         ['f', "6"],
//         ['g', "7"],
//         ['h', "8"],
//         ['i', "9"],
//         ['j', "10"],
//         ['k', "11"],
//         ['l', "12"],
//         ['m', "13"],
//         ['n', "14"],
//         ['o', "15"],
//         ['p', "16"],
//         ['q', "17"],
//         ['r', "18"],
//         ['s', "19"],
//         ['t', "20"],
//         ['u', "21"],
//         ['v', "22"],
//         ['w', "23"],
//         ['x', "24"],
//         ['y', "25"],
//         ['z', "26"],
//     ]);

//     let ans = "";

//     for(let i=0; i<s.length; i++) {
//         ans += charMap.get(s.charAt(i));
//     }

//     let sum = parseInt(ans);

//     for(let i=0; i<k; i++) {
//         sum = sumOfDigits(sum);
//     }

//     return sum;
// };