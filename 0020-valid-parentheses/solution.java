class Solution {
    public boolean isValid(String s) {

        if(s.length() <= 1)
        {
            return false;
        }

        Stack<Character> stack = new Stack<Character>(); 

        for (int i=0; i<s.length(); i++)
        {
            if ((s.charAt(i) == '(') || (s.charAt(i) == '{') || (s.charAt(i) == '['))
            {
                stack.push(s.charAt(i));
            }

            if (((s.charAt(i) == ')') || (s.charAt(i) == '}') || (s.charAt(i) == ']') )&& stack.empty())
            {
                return false;
            }

            if ((s.charAt(i) == ')') || (s.charAt(i) == '}') || (s.charAt(i) == ']'))
            {
                char check = (char) stack.pop();

                if(s.charAt(i) == ')' && check != '(')
                {
                    return false;
                }

                else if(s.charAt(i) == ']' && check != '[')
                {
                    return false;
                }

                else if(s.charAt(i) == '}' && check != '{')
                {
                    return false;
                }
            }
        }

        if(stack.empty())
        {
            return true;
        }

        else
        {
            return false;
        }
    }
}