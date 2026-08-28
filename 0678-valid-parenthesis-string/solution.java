class Solution {
    public boolean checkValidString(String s) {

        Stack<Integer>  bracketsStack = new Stack<>();
        Stack<Integer> asteriskStack = new Stack<>();
        char [] arr = s.toCharArray(); 

        for(int i=0;i<arr.length;i++)
        {
            char ch = arr[i];

            if(ch == '(')
            {
                bracketsStack.push(i);
            }
            else if(ch=='*') 
            {
                asteriskStack.push(i);
            }
            else if(!bracketsStack.isEmpty())
            {
                bracketsStack.pop();
            }
            else if(!asteriskStack.isEmpty())
            {
                asteriskStack.pop();
            }
            else
            {
                return false;
            }
        }

        while(!bracketsStack.isEmpty() && !asteriskStack.isEmpty() && 
                bracketsStack.peek()<asteriskStack.peek())
        {
            bracketsStack.pop();
            asteriskStack.pop();
        }

        return bracketsStack.isEmpty();
    }
}

// class Solution {
//     public boolean checkValidString(String s) {
        
//         int count = 0;
//         int charCount = 0;
//         for(int i=0; i<s.length(); i++)
//         {
//             if(s.charAt(i) == '(')
//             {
//                 count++;
//             }
//             if(s.charAt(i) == ')')
//             {
//                 count--;
//             }

//             if(s.charAt(i) == '*')
//             {
//                 charCount++;
//             }
//         }

//         if(count == 0)
//         {
//             return true;
//         }
//         else
//         {
//             if( (charCount >= count) || ( (charCount + count) > count) )
//             {
//                 return true;
//             }
//             return false;
//         }
//     }
// }