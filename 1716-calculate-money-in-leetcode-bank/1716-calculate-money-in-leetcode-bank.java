class Solution {
    public int totalMoney(int n) {
        int seven = n/7;
        int val = 7;
        int ans = 0;
        int i =1;
        for(i=1;i<=seven;i++){
            ans += val*(val+1)/2-((i)*(i-1)/2);
            val++;
        }
        val -= 6;
        for(i=0;i<n%7;i++){
            ans += val;
            val++;
        }
        return ans;
    }
}