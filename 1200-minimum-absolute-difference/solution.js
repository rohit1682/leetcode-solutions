/**
 * @param {number[]} arr
 * @return {number[][]}
 */
var minimumAbsDifference = function(arr) {
    arr.sort((a,b) => a-b);
    let map = new Map();
    for(let i=1; i<arr.length; i++) {
        let diff = Math.abs(arr[i-1] - arr[i]);
        if(!map.has(diff)) {
            map.set(diff, []);
        }
        map.get(diff).push([arr[i-1],arr[i]]);
    }
    let min = Math.min(...map.keys());
    return map.get(min);
};