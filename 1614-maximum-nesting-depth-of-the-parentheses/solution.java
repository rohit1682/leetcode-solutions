class Solution {
    public int maxDepth(String s) {
        
        int max = -1;
        int count = 0;
        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i) == '(')
            {
                count++;
            }
            else if(s.charAt(i) == ')')
            {
                count--;
            }

            if(max <= count)
            {
                max = count;
            }
        }
        return max;
    }
}