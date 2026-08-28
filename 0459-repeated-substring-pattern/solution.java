class Solution {
    public boolean repeatedSubstringPattern(String s) {

        // 1. Concatenate string s with itself.
        // 2. Remove the first and last character from the concatenated string and 
        //    check if the original string s is present.
        // 3. Return True if the string is present, otherwise False.

        String str = s + s;
        String str2 = str.substring(1, str.length() - 1);
        return str2.contains(s);
    }

    // public boolean repeatedSubstringPattern(String s) {

    //     if(s.length() == 1)
    //     {
    //         return false;
    //     }
        
    //     int[] charCount = new int[1000];
    //     Arrays.fill(charCount, -1);
    //     int max=-1;
        
    //     for(int i=0; i<s.length(); i++)
    //     {
    //         charCount[s.charAt(i)]++;
    //         if(max <= charCount[s.charAt(i)])
    //         {
    //             max = charCount[s.charAt(i)];
    //         }
    //     }

    //     for(int i=0; i<charCount.length; i++)
    //     {
    //         if( (charCount[i] != -1) && (charCount[i] != max) )
    //         {
    //             return false;
    //         }
    //     }

    //     return true;
    // }
}