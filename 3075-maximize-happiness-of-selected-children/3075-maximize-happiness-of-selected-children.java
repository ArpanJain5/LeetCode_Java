class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int count=0;
        long ans=0;
        while(count!=k){
            int value=happiness[happiness.length-1-count]-count;
            if(value>0){
                ans+=happiness[happiness.length-1-count]-count;
            }
            count++;
        }
        return ans;
    }
}