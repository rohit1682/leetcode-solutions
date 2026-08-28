class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> myMap = new HashMap<>();
        
        myMap.put('I', 1);
        myMap.put('V', 5);
        myMap.put('X', 10);
        myMap.put('L', 50);
        myMap.put('C', 100);
        myMap.put('D', 500);
        myMap.put('M', 1000);
        
        int ans = 0;
        
        for (int i = 0; i < s.length(); i++) 
        {
            if (i < s.length() - 1 && myMap.get(s.charAt(i)) < myMap.get(s.charAt(i + 1))) 
            {
                ans -= myMap.get(s.charAt(i));
            } 
            else 
            {
                ans += myMap.get(s.charAt(i));
            }
        }
        
        return ans;
    }
}

// class Solution {
//     public int romanToInt(String s) throws Exception
//     {
        
//         int num=0;
//         try{

//             for(int i=0;i<s.length();i++)
//             {
//                 if(s.charAt(i)=='I')
//                 {
//                     if(s.charAt(i+1)=='V'||s.charAt(i+1)=='X')
//                     {
//                         num--;
//                     }
//                     else
//                     {
//                         num=num+1;
//                     }
//                 }
//                 else if(s.charAt(i)=='V')
//                 {
//                     num=num+5;
//                 }
//                 else if(s.charAt(i)=='X')
//                 {
//                     if(s.charAt(i+1)=='L'||s.charAt(i+1)=='C')
//                     {
//                         num=num-10;
//                     }
//                     else
//                     {
//                         num=num+10;
//                     }
//                 }
//                 else if(s.charAt(i)=='L')
//                 {
//                     num=num+50;
//                 }
//                 else if(s.charAt(i)=='C')
//                 {
//                     if(s.charAt(i+1)=='D'||s.charAt(i+1)=='M')
//                     {
//                         num=num-100;
//                     }
//                     else
//                     {
//                         num=num+100;
//                     }
//                 }
//                 else if(s.charAt(i)=='D')
//                 {
//                     num=num+500;
//                 }
//                 else if(s.charAt(i)=='M')
//                 {
//                     num=num+1000;
//                 }
//             }
            
//         }
        
//         catch (Exception e)
//         {
//             System.out.println("");
//         }
//         return num;
//     }
// }