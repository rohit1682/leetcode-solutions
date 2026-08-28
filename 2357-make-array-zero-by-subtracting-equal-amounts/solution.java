class Solution {
    public int minimumOperations(int[] nums) {
        
        HashSet<Integer> s= new HashSet<>();
        //hash set only includes unique elements
    
        for(var i:nums)
        {
            if(i!=0) 
            {
                s.add(i);
            }
        } 

        return s.size();
    }
}