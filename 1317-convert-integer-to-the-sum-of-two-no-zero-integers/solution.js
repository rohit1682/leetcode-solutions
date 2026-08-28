/**
 * @param {number} n
 * @return {number[]}
 */
var getNoZeroIntegers = function(n) {
    const check = (n) => {
        while (n > 0){
            if (n % 10 === 0){
                return false;
            }
            n = Math.floor(n / 10);
        }
        return true;
    };
    for (let j = 1; j < n; j++){
        let i = n - j;
        if (check(i) && check(j)){
            return [i, j];
        }
    }
    return [];
};