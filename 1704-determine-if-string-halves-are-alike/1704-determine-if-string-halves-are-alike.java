class Solution {
    public boolean halvesAreAlike(String s) {
        s=s.toLowerCase();
        int count=0;
        int start=0;
        int end=s.length()-1;
        while(start<end){
            if(isVowel(s.charAt(start))) count++;     
            if(isVowel(s.charAt(end))) count--;         
            start++;
            end--;
        }
        return count==0;
    }
    public boolean isVowel(char ch){
        return ch=='a' || ch=='e' ||ch=='i' ||ch=='o' ||ch=='u';
    }
}