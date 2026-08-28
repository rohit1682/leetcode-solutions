class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char element : s.toCharArray()) {
            
            if (!stack.isEmpty() && Math.abs(element - stack.peek()) == 32) 
            {
                stack.pop();
            } 
            else 
            {
                stack.push(element);
            }
        }
        
        StringBuilder result = new StringBuilder();
        
        while (!stack.isEmpty()) 
        {
            result.insert(0, stack.pop());
        }
        
        return result.toString();
    }
}

// class Solution {
//     public String makeGood(String s) {
        
//         if(s.length() < 2)
//         {
//             return s;
//         }

//         int flag = -1;

//         do
//         {
//             flag = -1;
//             for(int i=1; i<s.length()-1; i++)
//             {
//                 if( (int)(s.charAt(i)) >= 65 && (int)(s.charAt(i)) <= 90 )
//                 {
//                     flag = 0;
//                     if( (int)(s.charAt(i+1)) == ((int)(s.charAt(i))+32) )
//                     {
//                         s=change(s, i, i+1 );
//                     }
//                     else if( (int)(s.charAt(i-1)) == ((int)(s.charAt(i))+32) )
//                     {
//                         s=change(s, i, i-1 );
//                     }
//                     flag = -1;
//                 }
//             }
//         }
//         while(flag != -1);

//         return s;
//     }

//     String change( String s, int x, int y )
//     {
//         String str="";

//         for(int i=0; i<s.length(); i++)
//         {
//             if( (i != x) || (i != y) )
//             {
//                 str= str+s.charAt(i);
//             }
//         }

//         return str;
//     }
// }