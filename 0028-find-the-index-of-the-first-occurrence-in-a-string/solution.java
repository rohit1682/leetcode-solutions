class Solution {
    public int strStr(String haystack, String needle) {
       
        if(haystack.length() < needle.length())
        {
            return -1;
        }


        for (int i=0; i< haystack.length(); i++)
        {
            if((i+needle.length()) <= haystack.length())
            {
                String sub = haystack.substring(i, (i+needle.length()));

                if(sub.equals(needle))
                {
                    return i;
                }


                // int flag=0;
                // int j=0;
                // while(j<needle.length())
                // {
                //     if((haystack.charAt(i+j) != needle.charAt(j)) && ((i+j)< haystack.length()))
                //     {
                //         flag=1;
                //         break;
                //     }
                //     else
                //     {
                //         j++;
                //     }
                // }

                // if(flag==0)
                // {
                //     return i;
                // }
            }
        }
        return -1;
        
    }
}