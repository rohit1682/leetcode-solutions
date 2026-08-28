class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans=new HashSet<>();
        List<List<Integer>> finalAns=new ArrayList<>();

        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++)
        {
            int j=i+1;
            int k=nums.length-1;
           
            while(j<k)
            {int sum=nums[i]+nums[j]+nums[k];
                if(sum==0)
                {
                    ans.add(Arrays.asList(nums[i],nums[j],nums[k]));
                    j++;
                    k--;
                }
                else if(sum>0)
                {
                    k--;
                }
                else
                {
                    j++;
                }
            }
        }
        finalAns.addAll(ans);
        return finalAns;
    }
}

// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
        
//         Set<List<Integer>> ans = new HashSet<>();
//         List<List<Integer>> finalAns = new ArrayList<>();

//         Arrays.sort(nums);

//         for(int i=0; i<nums.length; i++)
//         {
//             for(int j=0; j<nums.length; j++)
//             {
//                 for(int k=0; k<nums.length; k++)
//                 {
//                     // if((i==j) || (j == k) ) continue;

//                     if( (i!=j) && (j!=k) )
//                     {
//                         int sum= (nums[i]+nums[j]+nums[k]);

//                         if(sum == 0) 
//                         {                            
//                             ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
//                         } 
//                     }
//                 }
//             }
//         }

//         finalAns.addAll(ans);
//         return finalAns;

//         // for (List<Integer> element : ans) 
//         // {
//         //     int a = element.get(0);
//         //     int b = element.get(1); 
//         //     int c = element.get(2); 

//         //     List<Integer> temp1 = new ArrayList<Integer>(3);
//         //     temp1.add(a);
//         //     temp1.add(b);
//         //     temp1.add(c);
            
//         //     List<Integer> temp2 = new ArrayList<Integer>(3);
//         //     temp2.add(c);
//         //     temp2.add(b);
//         //     temp2.add(a);
        
//         //     List<Integer> temp3 = new ArrayList<Integer>(3);
//         //     temp3.add(c);
//         //     temp3.add(a);
//         //     temp3.add(b);

//         //     List<Integer> temp4 = new ArrayList<Integer>(3);
//         //     temp3.add(b);
//         //     temp3.add(a);
//         //     temp3.add(c);

//         //     List<Integer> temp5 = new ArrayList<Integer>(3);
//         //     temp3.add(a);
//         //     temp3.add(c);
//         //     temp3.add(b);

//         //     List<Integer> temp6 = new ArrayList<Integer>(3);
//         //     temp3.add(b);
//         //     temp3.add(c);
//         //     temp3.add(a);

//         //     if(!finalAns.contains(temp1) && !finalAns.contains(temp2) && !finalAns.contains(temp3)
//         //     && !finalAns.contains(temp4) && !finalAns.contains(temp5) && !finalAns.contains(temp6)) 
//         //     {
//         //         finalAns.add(element);
//         //     }
//         // }

//         // return finalAns;
//     }
// }