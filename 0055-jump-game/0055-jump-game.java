class Solution {
    public boolean canJump(int[] nums) {
        int maxDist = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i > maxDist) return false;
            maxDist = Math.max(i + nums[i], maxDist);
        }
        return true;
    }
}