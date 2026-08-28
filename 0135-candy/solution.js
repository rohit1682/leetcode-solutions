/**
 * @param {number[]} ratings
 * @return {number}
 */
var candy = function(ratings) {
    let left = new Array(ratings.length);
    let right = new Array(ratings.length);

    left[0] = 1;
    right[ratings.length-1] = 1;

    for(let i=0; i<ratings.length; i++) {
        if(ratings[i] > ratings[i-1]) left[i] = left[i-1]+1;
        else left[i] = 1;
    }

    for(let i=ratings.length-2; i>=0; i--) {
        if(ratings[i] > ratings[i+1]) right[i] = right[i+1]+1;
        else right[i] = 1;
    }

    let ans = 0;

    for(let i=0; i<ratings.length; i++) {
        ans += Math.max(left[i], right[i]);
    }

    return ans;
};