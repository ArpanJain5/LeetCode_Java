class Solution {
    private static int[][] deltas = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public void dfs(int row, int col, int[][] grid, boolean[][] was) {
        was[row][col] = true;
        for (int[] delta : deltas) {
            int nextRow = row + delta[0];
            int nextCol = col + delta[1];
            if (0 <= nextRow && nextRow < grid.length && 0 <= nextCol && nextCol < grid[0].length && 
                !was[nextRow][nextCol] && 
                grid[row][col] == 1
            ) {
                dfs(nextRow, nextCol, grid, was);
            }
        }
    }
    public boolean checkSingleAns(int delRow, int delCol, int[][] grid) {
        if (delRow != -1) {
            grid[delRow][delCol] = 0;
        }
        boolean[][] was = new boolean[grid.length][grid[0].length];
        int comps = 0;
        for (int row = 0; row < grid.length; ++row) {
            for (int col = 0; col < grid[0].length; ++col) {
                if (grid[row][col] == 1 && !was[row][col]) {
                    comps++;
                    dfs(row, col, grid, was);
                }
            }
        }
        if (delRow != -1) {
            grid[delRow][delCol] = 1;
        }
        return comps != 1; 
    }
    public int minDays(int[][] grid) {
        if (checkSingleAns(-1, -1, grid)) {
            return 0;
        }
        for (int row = 0; row < grid.length; ++row) {
            for (int col = 0; col < grid[0].length; ++col) {
                if (grid[row][col] == 1 && checkSingleAns(row, col, grid)) {
                    return 1;
                }
            }
        }
        return 2;
    }
}