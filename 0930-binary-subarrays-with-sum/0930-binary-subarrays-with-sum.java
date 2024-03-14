class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer,Integer> mpp=new HashMap<>();
        mpp.put(0,1);
        int cnt=0;
        int presum=0;
        for(int i=0;i<nums.length;i++)
        {
          presum+=nums[i];
          int remove=presum-goal;
          if(mpp.containsKey(remove))
          {
            cnt+=mpp.get(remove);
          }
          mpp.put(presum,mpp.getOrDefault(presum,0)+1);
        }
        return cnt;
    }
}