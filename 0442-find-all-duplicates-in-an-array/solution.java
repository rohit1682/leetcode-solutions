class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        HashMap<Integer,Integer> hash =new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for(int num :nums)
        {
            hash.put(num , hash.getOrDefault(num,0)+1);
        }  
        for(int num: hash.keySet())
        {
            if(hash.get(num)>1)
            {
                list.add(num);
            }
        }

        return list;
    }
}