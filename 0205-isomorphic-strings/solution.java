class Solution {
    public boolean isIsomorphic(String s, String t) 
    {

        int[] count1 = new int[200]; 
        int[] count2 = new int[200]; 
        
        if(s.length() != t.length()) 
        {
            return false;
        }
        
        for(int i = 0; i < s.length(); i++) 
        {
            if(count1[s.charAt(i)] != count2[t.charAt(i)]) 
            {
                return false; 
            }
            
            count1[s.charAt(i)] = i + 1; 
            count2[t.charAt(i)] = i + 1; 
        }
        
        return true;
    }
}



// class Solution {
//     public boolean isIsomorphic(String s, String t) {

//         if(countFrequency(s) == countFrequency(t))
//         {
//             return true;
//         }

//         else
//         {
//             return false;
//         }
//     }

//     int countFrequency(String str)
//     {
//         int[] frequency = new int[str.length()];
//         Arrays.fill(frequency, 0);
//         int c=0;

//         for(int i=0; i<str.length(); i++)
//         {
//             for(int j=i; j>=0; j--)
//             {
//                 if(str.charAt(i) == str.charAt(j))
//                 {
//                     frequency[c]++;
//                 }
//                 else
//                 {
//                     c++;
//                     frequency[c]++;
//                     break;
//                 }
//             }
//         }

//         int ans = 0;

//         for(int i=frequency.length-1; i>=0; i--)
//         {
//             ans = (ans*10) + frequency[i];
//         }

//         return ans;
//     }
// }

// class Solution {
//     public boolean isIsomorphic(String s, String t) {
        
//         if(frequencyCount(s) == frequencyCount(t))
//         {
//             return true;
//         }

//         else
//         {
//             return false;
//         }
//     }

//     int frequencyCount(String str)
//     {
//         int[] frequency = new int[1000];
//         Arrays.fill(frequency, 1);
//         int count = 1;

//         for(int i=0; i<str.length(); i++)
//         {
//             frequency[ (int)(str.charAt(i)) ]++;
//         }

//         for(int i=0; i<frequency.length; i++)
//         {
//             count *= frequency[i];
//         }

//         return count;
//     }
// }