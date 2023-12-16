class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq=new int[26];
        for(char c:s.toCharArray()){
            freq[c-'a']++;
        }
        for(char c:t.toCharArray()){
            freq[c-'a']--;
        }
        return Arrays.stream(freq).allMatch(x->x==0);
    }
}