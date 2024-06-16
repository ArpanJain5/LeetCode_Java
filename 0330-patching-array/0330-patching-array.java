class Solution {
    public int minPatches(int[] nums, int n) {
        long count=1;
        int ans=0;
        int i=0;
        while(count<=n){
            if(i<nums.length && nums[i]<=count){
                count+=nums[i];
                i++;
            }
            else{
                count+=count; 
                ans++;
            }
        }
        return ans;

    }
}