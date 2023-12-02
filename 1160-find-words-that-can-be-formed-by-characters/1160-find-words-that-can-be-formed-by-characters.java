class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] alpha = new int[26];
        for(int i=0; i<chars.length(); i++){
            alpha[chars.charAt(i) - 'a']++;
        }
        int ans = 0;
        for(String word : words){
            int flag = 0;
            int[] wordArr = new int[26];
            for(int i=0; i<word.length(); i++){
                wordArr[word.charAt(i) - 'a']++;
            }
            for(int i=0; i<26; i++){
                if(wordArr[i] > alpha[i]){
                    flag++;
                    break;
                }
            }
            if(flag == 0){
                ans += word.length();
            }
        }
        return ans;
    }
}