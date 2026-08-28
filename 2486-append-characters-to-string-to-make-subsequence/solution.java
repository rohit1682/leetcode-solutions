class Solution {
    public int appendCharacters(String s, String t) {
        int indx1=0,indx2=0;
        while((indx1 < s.length())&&(indx2 < t.length())) {
            if(s.charAt(indx1)==t.charAt(indx2)) indx2++;
            indx1++;
        }
        return t.length()-indx2;
    }
}