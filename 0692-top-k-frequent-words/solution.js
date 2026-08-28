/**
 * @param {string[]} words
 * @param {number} k
 * @return {string[]}
 */
var topKFrequent = function(words, k) {
    let wordFreq = new Map();
    for(let word of words) {
        wordFreq.set(word, ((wordFreq.get(word) || 0) + 1) );
    }
    const sortedKeys = [...wordFreq.keys()].sort((a, b) => {
        if (wordFreq.get(a) === wordFreq.get(b)) {
            return a.localeCompare(b); 
        }
        return wordFreq.get(b) - wordFreq.get(a); 
    });
    return sortedKeys.slice(0,k);
};