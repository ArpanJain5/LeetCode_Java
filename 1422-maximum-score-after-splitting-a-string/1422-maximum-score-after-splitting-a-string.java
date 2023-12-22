class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int[] ones = new int[n];
        int count = 0; 
        for(int i=n-1; i>=0; i--){
            if(s.charAt(i) == '1') ones[i] = ++count ; 
            else ones[i] = count; 
        }
        int max = 0, zeros = 0;
        for(int i=0; i<n-1; i++){
            if(s.charAt(i) == '0'){
                zeros++;
            }
            max = Math.max(max, zeros + ones[i+1]);
        }
        return max; 
    }
}