class Solution {
    Integer dp[][];
    public int helper(int idx, int arr[], Integer dp[][], int prev){
        int n = arr.length;
        if(idx == n) return 0;
        if(dp[idx][prev+1] != null) return dp[idx][prev+1];
        int nottake = helper(idx+1,arr,dp,prev);
        int take = 0;
        if(prev == -1 || arr[idx]>arr[prev]){
            take = helper(idx+1,arr,dp,idx)+1;
        }
        return dp[idx][prev+1] = Math.max(nottake,take);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new Integer[n][n+1];
        return helper(0,nums,dp,-1);
    }
}