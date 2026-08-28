/**
 * @param {number} k
 * @return {character}
 */
var kthCharacter = function(k) {
    let word = 'a';
    while(word.length <= k) {
        word = newWord(word);
    }
    return word.charAt(k-1);
};

var newWord = function(word) {
    let newWord = '';
    for(let i=0; i<word.length; i++) {
        newWord += String.fromCharCode(word.charCodeAt(i) + 1);
    }
    return word+newWord;
}