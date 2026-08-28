class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int[] minRow = new int[matrix.length];
        int[] maxCol = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            minRow[i] = Integer.MAX_VALUE;
            for (int j = 0; j < matrix[0].length; j++) {
                minRow[i] = Math.min(minRow[i], matrix[i][j]);
                maxCol[j] = Math.max(maxCol[j], matrix[i][j]);
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == minRow[i] && matrix[i][j] == maxCol[j]) {
                    ans.add(matrix[i][j]);
                }
            }
        }

        return ans;
    }
}