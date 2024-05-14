class Solution {
    int maximum = 0;
    public int getMaximumGold(int[][] grid) {
        int len = grid.length;
        for(int i = 0; i < len; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 0) continue;
                solve(grid, i, j, 0);
            }
        }
        return maximum;
    }
    public void solve(int[][] grid, int i, int j, int sum) {
        int rowSize = grid.length, colSize = grid[0].length;
        if(i < 0 || j < 0 || i >= rowSize || j >= colSize || grid[i][j]==0||grid[i][j] == -1)
            return;
        sum += grid[i][j];
        maximum = Math.max(maximum, sum);
        int val = grid[i][j];
        grid[i][j] = -1;
        solve(grid, i - 1, j, sum);
        solve(grid, i + 1, j, sum);
        solve(grid, i , j - 1, sum);
        solve(grid, i, j + 1, sum);
        grid[i][j] = val;
    }
}