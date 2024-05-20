class Solution {
    public int subset(int [] nums, int start, int end, int ans){
        if(start == end) return ans;
        return subset(nums, start+1, end, ans^nums[start]) + subset(nums, start+1, end, ans);
        }
        public int subsetXORSum(int[] nums) {
            return subset(nums, 0, nums.length, 0);
    }
}