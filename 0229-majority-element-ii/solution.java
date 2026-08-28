class Solution {
    public List<Integer> majorityElement(int[] nums) {
        
        List<Integer> myList = new ArrayList<Integer>(nums.length);
        List<Integer> finalList = new ArrayList<Integer>(nums.length);
        int check = (int) (nums.length/3);

        for(int i=0; i< nums.length; i++)
        {
            if(!myList.contains( nums[i] ))
            {
                myList.add(nums[i]);
                int count=0;
                for(int j=0; j<nums.length; j++)
                {
                    if(nums[j] == nums[i])
                    {
                        count++;
                    }
                }
                if(count>check)
                {
                    finalList.add(nums[i]);
                }
            }
        }

        return finalList;
    }
}