/**
 * @param {number[][]} grid
 * @return {number[]}
 */
var findMissingAndRepeatedValues = function(grid) {
    const n = grid.length;
    let r = 0, m = 0;
    const a = new Array(n * n).fill(0);
    for (let i = 0; i < n; i++) for (let j = 0; j < n; j++) a[grid[i][j] - 1]++; 
    for (let i = 0; i < n * n; i++) if (a[i] === 0) m = i + 1; else if (a[i] === 2) r = i + 1; 
    return [r, m];
};