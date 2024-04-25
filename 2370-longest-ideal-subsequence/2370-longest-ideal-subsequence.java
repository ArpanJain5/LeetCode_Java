class Solution {
    public int longestIdealString(String s, int k) {
        int[] dp = new int[26];
        for (char c : s.toCharArray()) {
            int curr = c - 'a';
            int longest = 1;
            for (int prev = 0; prev < 26; prev++) {
                if (Math.abs(curr - prev) <= k) {
                    longest = Math.max(longest, 1 + dp[prev]);
                }
            }
            dp[curr] = Math.max(dp[curr], longest);
        }
        int max = 0;
        for (int value : dp) {
            max = Math.max(max, value);
        }
        return max;
    }
}