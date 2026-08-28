class Solution {
    public void reverseString(char[] s) {
        int i, k;
        char t; 
        for (i = 0; i < s.length / 2; i++) { 
            t = s[i]; 
            s[i] = s[s.length - i - 1]; 
            s[s.length - i - 1] = t; 
        } 
    }
}