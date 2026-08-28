/**
 * @param {string} s
 * @return {number}
 */
var longestBalanced = function(s) {

    const n = s.length;
    if (n === 0) 
        return 0;

    // Case 1: single character - longest run of the same char
    let best = 1;
    let run = 1;
    for (let i = 1; i < n; i++) {
        if (s[i] === s[i - 1]) {
            run++;
        } else {
            if (run > best) 
                best = run;
            run = 1;
        }
    }
    if (run > best) 
        best = run;

    // Helper for Case 2: longest balanced substring for a pair (x,y)
    // we split by the third character and for each segment compute longest substring
    // where counts of x and y are equal using prefix-difference earliest-index map.
    function longestForPair(x, y, third) {
        let res = 0;
        let i = 0;
        while (i < n) {
            // we skip third chars
            if (s[i] === third) {
                i++;
                continue;
            }
            let j = i;
            while (j < n && s[j] !== third) 
                j++;
            // process segment s[i..j-1] containing only x and y
            const diffToIdx = new Map(); // diff -> earliest index
            diffToIdx.set(0, i - 1); // diff 0 at position before segment start
            let diff = 0;
            for (let k = i; k < j; k++) {
                if (s[k] === x) 
                    diff++;
                else if (s[k] === y) 
                    diff--;
                if (diffToIdx.has(diff)) {
                    const length = k - diffToIdx.get(diff);
                    if (length > res) 
                        res = length;
                } else {
                    diffToIdx.set(diff, k);
                }
            }
            i = j;
        }
        return res;
    }

    // Case 2: check all three pairs
    best = Math.max(
        best,
        longestForPair('a', 'b', 'c'),
        longestForPair('a', 'c', 'b'),
        longestForPair('b', 'c', 'a')
    );

    // Case 3: all three characters present - we use prefix counts and hash pair (b-a, c-a)
    // If the same pair appears at two indices, the substring between them has equal counts.
    let prefA = 0, prefB = 0, prefC = 0;
    const pairIndex = new Map(); // key "db,dc" -> earliest index
    pairIndex.set('0,0', -1);
    for (let i = 0; i < n; i++) {
        const ch = s[i];
        if (ch === 'a') 
            prefA++;
        else if (ch === 'b') 
            prefB++;
        else prefC++;
        const key = `${prefB - prefA},${prefC - prefA}`;
        if (pairIndex.has(key)) {
            const length = i - pairIndex.get(key);
            if (length > best) 
                best = length;
        } else {
            pairIndex.set(key, i);
        }
    }

    return best;
}