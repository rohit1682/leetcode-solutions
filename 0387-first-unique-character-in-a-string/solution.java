class Solution {
    public int firstUniqChar(String s) {
        for(int i=0;i<s.length();i++) {
            int flag=0;
            for(int j=0;j<s.length();j++) {
                if(j==i) continue;
                if(s.charAt(i)==s.charAt(j)) {
                    flag=1;
                    break;
                }
            }
            if(flag==1) continue;
            return i;
        }
        return -1;
    }
}