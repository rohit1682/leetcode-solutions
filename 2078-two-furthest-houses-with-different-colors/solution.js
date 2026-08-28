/**
 * @param {number[]} colors
 * @return {number}
 */
var maxDistance = function(colors) {
    let max= -Infinity;
    for(let i=0; i<=colors.length-1; i++){
        for(let j=i+1; j<=colors.length-1; j++){
            if(colors[j]!=colors[i] && j-i>max) max= j-i;
        }
    }

    return max;
};