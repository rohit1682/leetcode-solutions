class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i = 1; i<triangle.size(); i++) {
            List<Integer> currentRow = triangle.get(i);
            List<Integer> prevRow = triangle.get(i - 1);
            for(int j=0; j<currentRow.size(); j++) {

                int newValue = currentRow.get(j);

                if(j-1 < 0 && j < prevRow.size()) newValue += prevRow.get(j);
                else if(j >= prevRow.size() && j-1 >= 0) newValue += prevRow.get(j-1);
                else newValue += Math.min(prevRow.get(j) , prevRow.get(j-1));
                
                currentRow.set(j, newValue);
            }
        }

        List<Integer> currentRow = triangle.get(triangle.size()-1);
        int min = currentRow.get(0);
        for(int i=0; i<currentRow.size(); i++) {
            min = Math.min(min, currentRow.get(i));
        }

        return min;
    }
}