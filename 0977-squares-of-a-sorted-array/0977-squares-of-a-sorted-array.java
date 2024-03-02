class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int idx = nums.length - 1;
        int left = 0, right = nums.length - 1;
        int sq = 0;
        while (left <= right) {
            if (Math.abs(nums[left]) > Math.abs(nums[right])) {
                sq = nums[left++];
            } else {
                sq = nums[right--];
            }
            res[idx--] = sq * sq;
        }
        return res;
    }
}