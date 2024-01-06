class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int length = startTime.length;
        Job[] jobs = new Job[length];
        for(int i=0; i<length; i++){
            jobs[i]= new Job(startTime[i],endTime[i],profit[i]);    
        } 
        Arrays.sort(jobs, (a,b) -> Integer.compare(a.end, b.end));
        TreeMap<Integer, Integer> dp = new TreeMap<>();
        dp.put(0,0);
        for(Job job: jobs){
            Integer prevJobEnd = dp.floorKey(job.start);
            int currentProfit = dp.get(prevJobEnd)+ job.profit;
            int maxProfit = Math.max(currentProfit, dp.lastEntry().getValue());
            dp.put(job.end,maxProfit);
        }
        return dp.lastEntry().getValue();
    }
}
class Job{
    int start;
    int end;
    int profit;
    public Job(int start, int end, int profit){
        this.start = start;
        this.end = end;
        this.profit = profit;
    }
}