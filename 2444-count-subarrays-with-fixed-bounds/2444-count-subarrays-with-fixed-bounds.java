class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        long min = -1, max = -1, mix = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                mix = i;
            }
            if (nums[i] == minK) {
                min = i;
            }
            if (nums[i] == maxK) {
                max = i;
            }
            res += Math.max(0L, Math.min(max, min) - mix);
        }
        return res;
    }
}