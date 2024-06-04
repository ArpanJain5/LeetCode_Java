class Solution {
    public int longestPalindrome(String s) {
        int lowercase[] = new int[26];
        int uppercase[] = new int[26];

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);

            if(c-97 >= 0){
                lowercase[c-97]++;
            }else{
                uppercase[c-65]++;
            }
        }

        int ans = 0;
        boolean isFirstodd = false;

        for(int i=0;i<26;i++){
            if(lowercase[i]%2 == 0){
                ans += lowercase[i];

            }else{
                if(isFirstodd == false){
                    ans += lowercase[i];
                    isFirstodd = true;
                }else
                    ans += lowercase[i]-1;
            }
        }
    
        for(int i=0;i<26;i++){
            if(uppercase[i]%2 == 0){
                ans += uppercase[i];

            }else{
                if(isFirstodd == false){
                    ans += uppercase[i];
                    isFirstodd = true;
                }else
                    ans += uppercase[i]-1;
        }
        }
        return ans;
    }
}