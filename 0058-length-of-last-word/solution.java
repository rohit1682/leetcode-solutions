class Solution {
    public int lengthOfLastWord(String s) {
        
        String result="";
        int flag=0;

        for(int i=s.length()-1; i>=0; i--)
        {
            if((s.charAt(i) == ' ') && flag!=1)
            {
                continue;
            }

            else
            {
                flag=1;
                
                if(s.charAt(i) == ' ')
                {
                    break;
                }
                else
                {
                    result=result+s.charAt(i);
                }
                
            }
        }

        return (result.length());
    }
}