class Solution {
    public int minOperations(String s) {
      char tar1 = '0';
      char tar2 = '1';
      int  count1 = 0;
      int count2 = 0;
     for(int i=0;i<s.length();i++){
       if(i%2==0 && s.charAt(i)!=tar1){
           count1++;
       }
       else if(i%2!=0 && s.charAt(i)!=tar2){
           count1++;
       }
     }
     for(int i=0;i<s.length();i++){
       if(i%2==0 && s.charAt(i)!=tar2){
           count2++;
       }
       else if(i%2!=0 && s.charAt(i)!=tar1){
           count2++;
       }
     }
     int result = Math.min(count1,count2);
     return result;
    }
}