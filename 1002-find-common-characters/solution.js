/**
 * @param {string[]} words
 * @return {string[]}
 */
var commonChars = function(words) {
    let firstFreq = new Map();
    let ans = [];
    for(let element of words[0]) {
        firstFreq.set(element, (firstFreq.get(element) || 0) +1);
    }
    for(let word of words) {
        let eachFreq = new Map();
        for(let element of word) {
            eachFreq.set(element, (eachFreq.get(element) || 0) +1);
        }
        for(let [element, freq] of firstFreq) {
            if(eachFreq.has(element)) {
                firstFreq.set(element, Math.min(freq, eachFreq.get(element)));
            }
            else firstFreq.delete(element);
        }
    }
    for(let [element, freq] of firstFreq) {
        for(let i=0; i<freq; i++) ans.push(element);
    }
    return ans;
};