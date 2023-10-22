class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int left = k;
        int right = k;
        int minElement = nums[k];
        int maxScore = minElement;
        while (minElement > 0) {
            while (left > 0 && nums[left - 1] >= minElement) {
                left--;
            }
            while (right < n - 1 && nums[right + 1] >= minElement) {
                right++;
            }
            minElement = Math.min(minElement, Math.min(nums[left], nums[right]));
            maxScore = Math.max(maxScore, minElement * (right - left + 1));

            if (left > 0 && (right == n - 1 || nums[left - 1] > nums[right + 1])) {
                left--;
                minElement = nums[left];
            } else if (right < n - 1 && (left == 0 || nums[left - 1] <= nums[right + 1])) {
                right++;
                minElement = nums[right];
            } else {
                break;
            }
        }
        return maxScore;
    }
}