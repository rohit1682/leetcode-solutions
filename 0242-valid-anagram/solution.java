class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length()!=t.length())
        {
            return false;
        }
        char[] arr1 = s.toCharArray();
        char[] arr2 =t.toCharArray();
        HashMap<Character,Integer> hashmap =new HashMap<>();

        for(char i:arr1)
        {
            if(hashmap.containsKey(i))
            {
                hashmap.put(i,hashmap.get(i)+1);
            }
            else
            {
                hashmap.put(i,1);
            }
        
        }
        for(char i :arr2)
        {
            if(hashmap.containsKey(i))
            {
                hashmap.put(i,hashmap.get(i)-1);
            }
            else
            {
                return false;
            }
        }
        for(int count:hashmap.values())
        {
            if(count!=0)
            {
                return false;
            }
        }
        return true;
    }
}