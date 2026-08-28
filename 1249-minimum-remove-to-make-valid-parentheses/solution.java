class Solution {
    public String minRemoveToMakeValid(String s) {
        
        StringBuilder str = new StringBuilder();
        Stack<Integer> stack = new Stack<Integer>();
        int x=0;

        for(int i=0; i<s.length(); i++)
        {
            if(s.charAt(i) == '(')
            {
                stack.push(x);
            }
            if(s.charAt(i) == ')')
            {
                if(stack.empty())
                {
                    continue;
                }
                else
                {
                    stack.pop();
                }
            }

            str.append(s.charAt(i));
            x++;
        }

        while(!stack.empty())
        {
            str.deleteCharAt(stack.pop());
        }

        return str.toString();
    }
}