/**
 * @param {string} s
 * @param {number[]} shifts
 * @return {string}
 */
var shiftingLetters = function (s, shifts, res = "") {
  for (let i = shifts.length - 2; i >= 0; i--) {
      shifts[i] += shifts[i + 1];}
  for (let i = 0; i < s.length; i++) {
    res += String.fromCharCode((s[i].charCodeAt(0) - 97 + shifts[i]) % 26+97);}
  return res;
};