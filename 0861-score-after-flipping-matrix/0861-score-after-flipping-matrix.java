class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (n == 1)
            return m;
        for (int i = 0; i < m; i++)
            if (grid[i][0] == 0)
                for (int j = 0; j < n; j++)
                    grid[i][j] ^= 1;
        for (int j = 1; j < n; j++) {
            int cnt1 = 0;
            for (int i = 0; i < m; i++)
                cnt1 += grid[i][j];
            if (cnt1 <= m / 2)
                for (int i = 0; i < m; i++)
                    grid[i][j] ^= 1;
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            int rowSum = 0;
            for (int j = 0; j < n; j++)
                rowSum = rowSum * 2 + grid[i][j];
            ans += rowSum;
        }
        return ans;
    }
}