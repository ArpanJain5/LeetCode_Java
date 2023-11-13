class Solution {
    public String sortVowels(String s) {
        int cnt[] = new int[10];
        char str[]=s.toCharArray();
        for(int i=0;i<str.length;i++) {
            int ind="AEIOUaeiou".indexOf(str[i]);
            if(ind>=0) cnt[ind]++;
        }
        for(int i=0, j=0;i<str.length;i++) {
            int ind="AEIOUaeiou".indexOf(str[i]);
            if(ind>=0) {
                while(cnt[j]==0) j++;
                str[i]="AEIOUaeiou".charAt(j);
                cnt[j]--;
            }
        }
        return new String(str);
    }
}