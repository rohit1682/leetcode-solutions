/**
 * @param {string} num
 * @return {string}
 */
var largestPalindromic = function(num) {
    const freq = Array(10).fill(0);
  for (let digit of num) freq[digit]++;

  let left = '', middle = '';
  for (let i = 9; i >= 0; i--) {
    if (freq[i] % 2 === 1 && !middle) middle = i;    
    left += String(i).repeat(Math.floor(freq[i] / 2)); 
  }

  if (!left.length || left[0] === '0') return middle ? String(middle) : '0';
  return left + middle + [...left].reverse().join('');
};