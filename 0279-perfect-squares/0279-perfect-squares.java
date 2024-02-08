class Solution {
    private int solveRec(int n){
        if(n==0) return 0;
        int ans = Integer.MAX_VALUE;
        for(int i=1; i*i<=n; i++){
            ans = Math.min(ans, 1 + solveRec(n-(i*i)));
        }
        return ans;
    }
    private int solveMemo(int n, int []dp){
        if(n == 0) return 0 ;
        if(dp[n] != -1) return dp[n];
        int ans = Integer.MAX_VALUE;
        for(int i=1; i*i<=n; ++i){
            ans = Math.min(ans, 1 + solveMemo(n-(i*i), dp));
        }
        return dp[n]=ans;
    }
    public int numSquares(int n) {
        int [] dp = new int[n+1];
        for(int i=0; i<=n; i++) {
            Arrays.fill(dp, -1);
        }
        return solveMemo(n, dp);
    }
}