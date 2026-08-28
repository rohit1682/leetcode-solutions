/**
 * @param {number[][]} matrix
 * @param {number} target
 * @return {boolean}
 */
var searchMatrix = function(matrix, target) {
    if(matrix.length === 0 || matrix === null) return false;
    let rows = matrix.length;
    let cols = matrix[0].length;

    for(let i=0; i<rows; i++) {
        if(find(matrix[i], 0, cols-1, target)) return true;
    }
    return false;
};

function find(row, low, high, target) {
    if(low > high) return false;
    let mid = low + Math.floor((high-low)/2);
    if(target < row[mid]) return find(row, low, mid-1, target);
    else if(target > row[mid]) return find(row, mid+1, high, target);
    else return true;
}