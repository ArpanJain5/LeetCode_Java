class Solution {
    private Integer[][][] memoInc;
    private Integer[][][] memoDec;
    public int solve(int rating[], int i, int prev, int count, boolean isIncreasing, Integer[][][] memo) {
        if (count == 3) {
            return 1;
        }
        if (i >= rating.length) {
            return 0;
        }
        if (memo[i][prev + 1][count] != null) {
            return memo[i][prev + 1][count];
        }
        int take = 0;
        if (prev == -1 || (isIncreasing ? rating[prev] < rating[i] : rating[prev] > rating[i])) {
            take = solve(rating, i + 1, i, count + 1, isIncreasing, memo);
        }
        int notake = solve(rating, i + 1, prev, count, isIncreasing, memo);
        memo[i][prev + 1][count] = take + notake;
        return memo[i][prev + 1][count];
    }
    public int numTeams(int[] rating) {
        int n = rating.length;
        memoInc = new Integer[n][n + 1][4];
        memoDec = new Integer[n][n + 1][4];
        int increase = solve(rating, 0, -1, 0, true, memoInc);
        int decrease = solve(rating, 0, -1, 0, false, memoDec);
        return increase + decrease;
    }
}