class Solution {
    public int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int Ones[] = new int[m+n];
        int Zeroes[] = new int[m+n];
        int idx = 0;
        for (int i = 0; i < m ; i++) {
            int countOnes = 0;
            int countZeroes = 0;
            for (int j = 0; j < n ; j++) {
                if (grid[i][j] == 1) {
                    countOnes += 1;
                } else {
                    countZeroes += 1;
                }
            }
            Ones[idx] = countOnes;
            Zeroes[idx] = countZeroes;
            idx += 1;
        } 
        for (int j = 0; j < n ; j++) {
            int countOnes = 0;
            int countZeroes = 0;
            for (int i = 0; i < m ; i++) {
                if (grid[i][j] == 1) {
                    countOnes += 1;
                } else {
                    countZeroes += 1;
                }
            }
            Ones[idx] = countOnes;
            Zeroes[idx] = countZeroes;
            idx += 1;
        }
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n ; j++) {
                grid[i][j] = Ones[i] + Ones[m+j] - Zeroes[i] - Zeroes[m+j];
            }
        }
        return grid;
    }
}