class Solution {
    public int findRotateSteps(String ring, String key) {
        int[][] dp = new int[ring.length()][key.length()];

        return helper(ring, 0, key, 0, dp);
    }

    public int helper(String ring, int ringIdx, String key, int keyIdx, int[][] dp){
        if(keyIdx == key.length()){
            return 0;
        }

        if(dp[ringIdx][keyIdx] != 0){
            return dp[ringIdx][keyIdx];
        }

        int ans = Integer.MAX_VALUE;
        for(int i = 0; i < ring.length(); i++){
            if(ring.charAt(i) == key.charAt(keyIdx)){
                int clockwise = Math.abs(i - ringIdx);
                int antiClockwise = ring.length() - clockwise;
                int minimum = Math.min(clockwise, antiClockwise);

                minimum += helper(ring, i, key, keyIdx+1, dp) + 1;
                ans = Math.min(ans, minimum);
            }
        }
        return dp[ringIdx][keyIdx] = ans;
    }
}