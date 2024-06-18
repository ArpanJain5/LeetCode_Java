class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int max=0;
        int netprofit=0;
        
        for(int i=0; i<worker.length; i++) {
            max = 0; 
            
            for(int j=0; j<profit.length; j++) {
                if(worker[i] >= difficulty[j]) {
                    max = Math.max(max, profit[j]);
                }
            }
            netprofit += max;
        }
        
        return netprofit;
    }
}