class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> result = new ArrayList<>();
        Integer row1[] = new Integer[colsum.length];
        Integer row2[] = new Integer[colsum.length];

        Arrays.fill(row1, 0);
        Arrays.fill(row2, 0);
        
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 2) {
                row1[i] = 1;
                row2[i] = 1;
                upper--;
                lower--;
            }
        }
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 1) {
                if (upper > 0) {
                    row1[i] = 1;
                    upper--;
                } else if (lower > 0) {
                    row2[i] = 1;
                    lower--;
                } else {
                    return result;
                }
            }
        }
        if (upper != 0 || lower != 0) {
            return result;
        }
        result.add(Arrays.asList(row1));
        result.add(Arrays.asList(row2));
        return result;
    }
}

// just need to check if upper is greater than lower or not at every iteration
// class Solution {
//     public List<List<Integer>> 
//     reconstructMatrix(int upper, int lower, int[] colsum) {
//         List<List<Integer>> ans = new ArrayList<List<Integer>>();
//         List<Integer> row1 = new ArrayList<Integer>();
//         List<Integer> row2 = new ArrayList<Integer>(); 

//         for(int i=0;i<colsum.length;i++) {
//             if(upper>0&&colsum[i]>0) {
//                 row1.add(1);
//                 upper--;
//                 colsum[i]--;
//             }
//             else row1.add(0);
//             if(lower>0&&colsum[i]>0) {
//                 row2.add(1);
//                 lower--;
//                 colsum[i]--;
//             }
//             else row2.add(0);
//         }
//         if(upper==0&&lower==0&&colsum[colsum.length-1]==0) {
//             ans.add(row1);
//             ans.add(row2);
//             return ans;
//         } 
//         else return new ArrayList<List<Integer>>();
//     }
// }