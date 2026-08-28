class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                if (isMagicSquare(grid, i, j)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean isMagicSquare(int[][] grid, int r, int c) {
        if (grid[r + 1][c + 1] != 5) {
            return false;
        }
        boolean[] seen = new boolean[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = grid[r + i][c + j];
                if (num < 1 || num > 9 || seen[num]) {
                    return false;
                }
                seen[num] = true;
            }
        }

        int sum = grid[r][c] + grid[r][c + 1] + grid[r][c + 2];
        if (grid[r + 1][c] + grid[r + 1][c + 1] + grid[r + 1][c + 2] != sum) return false;
        if (grid[r + 2][c] + grid[r + 2][c + 1] + grid[r + 2][c + 2] != sum) return false;

        if (grid[r][c] + grid[r + 1][c] + grid[r + 2][c] != sum) return false;
        if (grid[r][c + 1] + grid[r + 1][c + 1] + grid[r + 2][c + 1] != sum) return false;
        if (grid[r][c + 2] + grid[r + 1][c + 2] + grid[r + 2][c + 2] != sum) return false;

        if (grid[r][c] + grid[r + 1][c + 1] + grid[r + 2][c + 2] != sum) return false;
        if (grid[r][c + 2] + grid[r + 1][c + 1] + grid[r + 2][c] != sum) return false;

        return true;
    }
}