class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> out = new ArrayList<>();
        int st = newInterval[0];
        int end = newInterval[1];
        for(int i=0;i< intervals.length;i++){
            int nextSt = intervals[i][0];
            int nextEnd = intervals[i][1];
            if(end < nextSt){
                out.add(new int[]{st, end});
                st = nextSt;
                end = nextEnd;
            }else if(st > nextEnd){
                out.add(intervals[i]);
            } else {  
                st = Math.min(st, nextSt);
                end = Math.max(end, nextEnd);
            }
        }
        out.add(new int[]{st, end});
        int n = out.size();
        int[][] res = new int[n][2];
        out.toArray(res);
        return res;
    }
}