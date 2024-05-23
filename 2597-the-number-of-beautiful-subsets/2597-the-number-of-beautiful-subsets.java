class Solution {
    public int beautifulSubsets(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        return helper(nums,k,map,0,0)-1;
    }
    public int helper(int[] nums,int k,Map<Integer,Integer> map,int ind,int count){
        if(ind==nums.length){
            count++;
            return count;
        }
        int n = nums[ind];
        int take = 0;
        if(!map.containsKey(n+k)&&!map.containsKey(n-k)){
            map.put(n,map.getOrDefault(n,0)+1);
            take = helper(nums,k,map,ind+1,count);
            map.put(n,map.get(n)-1);
            if(map.get(n)==0){
                map.remove(n);
            }
        }
        int notTake = helper(nums,k,map,ind+1,count);
        return take+notTake;
    }
}