class Solution {
    public String reverseParentheses(String s) {
        Deque<Integer> indStack = new LinkedList<>();
        StringBuilder res = new StringBuilder();

        for (char char_s : s.toCharArray()) {
            if (char_s == '(') {
                indStack.push(res.length());
            } else if (char_s == ')') {
                int startInd = indStack.pop();
                String reversed = new StringBuilder(res.substring(startInd)).reverse().toString();
                res.replace(startInd, res.length(), reversed);
            } else {
                res.append(char_s);
            }
        }

        return res.toString();
    }
}

// class Solution {
//     public String reverseParentheses(String s) {
//         StringBuilder str = new StringBuilder("");
//         return myFunc(s,0,str);
//     }

//     String myFunc(String s, int i, StringBuilder str) {
//         if(s.charAt(i)=='(') {
//             StringBuilder str2=new StringBuilder("");
//             str.append(myFunc(s, ++i, str2));
//         }
//         else if(s.charAt(i)==')') return str.reverse().toString();
//         else {
//             str.append(s.charAt(i));
//             myFunc(s,++i,str);
//         }
//         return str.toString();
//     }
// }