class Solution {
    int groupBySize(Map<Integer, Integer> countFreq, int size, int n){
        int group=0;
        for(Map.Entry<Integer, Integer> e:countFreq.entrySet()){
            int len=e.getKey();
            int rem=len%(size+1);
            int g=len/(size+1);
            if(rem==0){
                group+=g*e.getValue();
                continue;
            }
            int need=size-rem;
            if (g>=need) {
                group+=(g+1)*e.getValue();
                continue;
            }
            return -1;
        }
        return group;
    }
    public int minGroupsForValidAssignment(int[] nums) {
        int n=nums.length;
        Map<Integer, Integer> count=new HashMap<>();
        for(int num:nums){
            count.merge(num,1,Integer::sum);
        }
        int min=Integer.MAX_VALUE;
        Map<Integer,Integer> countFreq=new HashMap<>();
        for(int c:count.values()) {
            countFreq.merge(c,1,Integer::sum);
        }
        for(int c:countFreq.keySet()){
            min=Math.min(min,c);
        }
        for(int size=min;size>=1;size--){
            int group=groupBySize(countFreq,size,n);
            if(group>0){
                return group;
            }
        }
        return -1;
    }
}