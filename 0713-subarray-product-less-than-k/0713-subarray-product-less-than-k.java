class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1) return 0;
        int mul = 1;
        int left=0;
        int result=0;
        for(int right=0;right<nums.length;right++){
             mul*=nums[right];
             while(mul>=k){
              mul=mul/nums[left];
              left++;
             }
             result+=right-left+1;
        }
        return result;
    }
}