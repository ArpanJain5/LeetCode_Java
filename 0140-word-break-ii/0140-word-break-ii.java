class Solution {
    private List<String> solve(String s, int start, HashSet<String> dict, HashMap<Integer, List<String>> memo){
        if(memo.containsKey(start))
            return memo.get(start);
        
        List<String> validSubstr = new ArrayList<>();
        if(start == s.length())
            validSubstr.add("");
        
        for(int end = start+1; end<=s.length(); end++){
            String prefix = s.substring(start, end);

            if(dict.contains(prefix)){
                List<String> suffixes = solve(s, end, dict, memo);

                for(String suffix : suffixes){
                    validSubstr.add(prefix + (suffix.equals("")? "": " ") + suffix);
                }
            }
        }

        memo.put(start, validSubstr);
        return validSubstr;
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        HashMap<Integer, List<String>> memo = new HashMap<>();

        return solve(s, 0, set, memo);
    }
}