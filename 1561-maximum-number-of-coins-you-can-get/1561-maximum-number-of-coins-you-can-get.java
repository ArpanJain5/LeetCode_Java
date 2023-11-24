class Solution {
    public int maxCoins(int[] piles) {
        int n = piles.length;
        int part = n - n / 3;
        Arrays.sort(piles);
        int res = 0;
        for(int i = n-1; i >= n-part; i-=2){
            res += piles[i-1];
        }
        return res;
    }
}