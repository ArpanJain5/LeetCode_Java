class Solution {
    public int reductionOperations(int[] nums) {
        int res = 0, n = nums.length;
    Arrays.sort(nums);
    for (int j = n - 1; j > 0; --j)
        if (nums[j - 1] != nums[j])
            res += n - j;
    return res;
    }
}