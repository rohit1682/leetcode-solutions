class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) 
    {
        int maxValIndex = 0;
        for(int i = 1; i < candies.length; i++)
        {
            if(candies[i] > candies[maxValIndex])
                maxValIndex = i;
        }
        List<Boolean> result = new ArrayList<>();

        for(int i = 0; i < candies.length; i++)
        {
            if(candies[i] + extraCandies >= candies[maxValIndex])
                result.add(true);
            else 
                result.add(false);
        }

        return result;
    }
}


//correct code
// class Solution {
//     public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        
//         ArrayList<Boolean> result = new ArrayList<Boolean>();

//         int max = Arrays.stream(candies).max().getAsInt();

//         for(int i=0; i<candies.length; i++)
//         {

//             if( (candies[i] + extraCandies) >= max)
//             {
//                 result.add(true);
//             }
//             else
//             {
//                 result.add(false);
//             }
//         }

//         return result;
//     }
// }