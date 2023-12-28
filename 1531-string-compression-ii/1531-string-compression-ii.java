class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        Map<String, Integer> dp = new HashMap<>();
        return solve(s, dp, Character.MIN_VALUE, 0, 0, k);
    }   
    public int solve(String s,Map<String,Integer>dp,char prevChar,int prevCharCount,int idx,int k){
        if(k < 0) return Integer.MAX_VALUE;
        if(idx == s.length()) return 0;
        String key = idx+"-"+prevChar+"-"+prevCharCount+"-"+k;
        if(dp.containsKey(key)) return dp.get(key);
        
        char currChar = s.charAt(idx);
        
        if(prevChar == currChar){
            int len = 0;
            if(prevCharCount == 1 || prevCharCount == 9 || prevCharCount == 99)
                len = 1;
            int ans = len + solve(s, dp, prevChar, prevCharCount + 1, idx+1, k);
            dp.put(key, ans);
        }else{
             int keep = 1 + solve(s, dp, currChar, 1, idx+1, k);
             int delete = solve(s, dp, prevChar, prevCharCount, idx+1, k-1);
            dp.put(key, Math.min(keep, delete));
        }
        return dp.get(key);
    }
}