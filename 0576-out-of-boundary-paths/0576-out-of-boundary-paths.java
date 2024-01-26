class Solution {
    static int mod = 1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m][n][maxMove+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }return dfs(m,n,maxMove,startRow,startColumn,dp);
    }
    public int dfs(int m,int n,int move,int row,int col,int[][][] dp){
        if(row<0 || row>= m || col>=n || col<0){
            return 1;
        }if(move==0){
            return 0;
        }if(dp[row][col][move]!=-1){
            return  dp[row][col][move];
        }int possibleDir[] = {-1,0,1,0,-1};
        int count = 0;
        for(int i=0;i<4;i++){
            int newRow = row+possibleDir[i];
            int newCol = col+possibleDir[i+1];
            count=(count+dfs(m,n,move-1,newRow,newCol,dp))%mod;
        }dp[row][col][move] = count;
        return count;
    }
}