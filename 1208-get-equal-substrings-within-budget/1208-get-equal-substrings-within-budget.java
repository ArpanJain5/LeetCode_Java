class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int len = t.length();
        int[] arr = new int[len];
        for(int i = 0 ; i < len ; i++){
            arr[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        int maxLen = 0;
        int l = 0;
        int r = 0;
        int sum = 0;
        while(r < len){
            sum += arr[r];
            if(sum > maxCost){
                sum -= arr[l];
                l++;
            }
            if(sum <= maxCost){
                maxLen = Math.max(maxLen, r - l + 1);
            }
            r++;
        }
        return maxLen;
    }
}