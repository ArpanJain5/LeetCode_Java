class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> Mp = new HashMap<>();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        while(right < nums.length){
            Mp.put(nums[right], Mp.getOrDefault(nums[right], 0)+1);
            while(Mp.get(nums[right]) > k){
                Mp.put(nums[left], Mp.get(nums[left]) - 1);
                if(Mp.get(nums[left]) == 0) Mp.remove(nums[left]);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}