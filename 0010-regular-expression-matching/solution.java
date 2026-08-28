class Solution {
    int sl, pl; 

    public boolean isMatch(int si, int pi, String s, String p, int[][] dp) {
        if (si >= sl && pi >= pl)
            return true;

        if (si < sl && pi >= pl)
            return false;

        if (si >= sl && pi < pl) {
            pi++;
            while (pi < pl) {
                if (p.charAt(pi) != '*') return false;
                pi += 2;
            }
            if (p.charAt(pl - 1) != '*') return false;
            return true;
        }

        if (dp[si][pi] != -1)
            return dp[si][pi] == 1;

        if (pi < pl - 1 && p.charAt(pi + 1) == '*') {
            boolean notUse = isMatch(si, pi + 2, s, p, dp);
            boolean use = (s.charAt(si) == p.charAt(pi) || p.charAt(pi) == '.') && isMatch(si + 1, pi, s, p, dp);
            dp[si][pi] = (notUse || use) ? 1 : 0;
            return notUse || use;
        }
        else if (p.charAt(pi) == '.' || s.charAt(si) == p.charAt(pi)) {
            boolean result = isMatch(si + 1, pi + 1, s, p, dp);
            dp[si][pi] = result ? 1 : 0;
            return result;
        }

        dp[si][pi] = 0;
        return false;
    }

    public boolean isMatch(String s, String p) 
    {
        sl = s.length();
        pl = p.length();
        int[][] dp = new int[sl + 1][pl + 1]; 
        
        for (int[] row : dp) 
        {
            Arrays.fill(row, -1);
        }
        return isMatch(0, 0, s, p, dp); 
    }

  
}

// class Solution {
//     public boolean isMatch(String s, String p) {
//         if(s.length()==p.length())
//         {
//             if(s.equalsIgnoreCase(p))
//             {
//                 return true;
//             }
//             else
//             {
//                 int flag=0;
//                 for(int i=0;i<s.length();i++)
//                 {
//                     if(s.charAt(i)==p.charAt(i))
//                     {
//                         continue;
//                     }
//                     else
//                     {
//                         if(s.charAt(i)=='.'||s.charAt(i)=='*'||p.charAt(i)=='.'||p.charAt(i)=='*')
//                         {
//                             continue;
//                         }
//                         else
//                         {
//                             flag=1;
//                         }
//                     }
//                 }
//                 if(flag==0)
//                 {
//                     return true;
//                 }
//                 else
//                 {
//                     return false;
//                 }
//             }
//         }
//         else
//         {
//             int flag1=0;
//             int flag2=0;
//             int i=0,j=0;
//             while(true)
//             {
//                 if(i==s.length()||j==p.length())
//                 {
//                     break;
//                 }
//                 if(s.charAt(i)=='*'||s.charAt(i)=='.')
//                 {
//                     flag1=1;
//                 }
//                 if(p.charAt(j)=='*'||p.charAt(j)=='.')
//                 {
//                     flag2=1;
//                 }
//                 i++;
//                 j++;
//             }
//             if(flag1!=1&&flag2!=1)
//             {
//                 return false;
//             }

//             i=0;
//             j=0;
//             int flag=0;
//             while(true)
//             {
//                 if(i==s.length()||j==p.length())
//                 {
//                     break;
//                 }
//                 if(s.charAt(i)=='.'||s.charAt(i)=='*')
//                 {
//                     i++;
//                     continue;
//                 }
//                 if(p.charAt(i)=='.'||p.charAt(i)=='*')
//                 {
//                     j++;
//                     continue;
//                 }
//                 if(s.charAt(i)==p.charAt(j))
//                 {
//                     i++;
//                     j++;
//                     continue;
//                 }
//                 else
//                 {
//                     flag=1;
//                     break;
//                 }
//             }
//             if(flag==0)
//             {
//                 return true;
//             }
//             else
//             {
//                 return false;
//             }
//         }
//     }
// }