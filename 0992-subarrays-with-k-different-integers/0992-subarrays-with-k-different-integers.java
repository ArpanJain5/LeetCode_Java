class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n = nums.length;
        return helper(nums, n, k) - helper(nums, n, k-1);
    }
    public int helper(int[] nums, int n, int k) {
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0, j = 0; j < n; j++) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            while(map.size() > k && i < n) {
                int lastCount = map.get(nums[i]);
                if(lastCount == 1) map.remove(nums[i]);
                else map.put(nums[i], lastCount - 1);
                i++;
            }
            ans += j-i+1;
        }
        return ans;
    }
}