class Solution {
    public char findTheDifference(String s, String t) {
        char[] arr1 =s.toCharArray();
        char[] arr2 =t.toCharArray();
        HashMap<Character,Integer> hashmap = new HashMap<>();
        for(char c:arr1)
        {
            hashmap.put(c , hashmap.getOrDefault(c,0)+1 );
        }
        for(char c:arr2)
        {
            if(!hashmap.containsKey(c) || hashmap.get(c)==0)
            {
                return c;
            }
            hashmap.put(c,hashmap.get(c)-1);

        }
        return ' ';
    }
}