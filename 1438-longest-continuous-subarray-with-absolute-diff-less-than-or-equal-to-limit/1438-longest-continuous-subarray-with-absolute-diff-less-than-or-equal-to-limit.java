class Solution {
    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(nums[0], 1);
        int n = nums.length;
        int res = 1;
        int low = 0;
        for (int i = 1; i < n; ++i) {
            int cur = nums[i];
            map.put(cur, map.getOrDefault(cur, 0) + 1);
            int maxDiff = Math.max(Math.abs(map.lastKey() - cur), Math.abs(map.firstKey() - cur));
            while (maxDiff > limit) {
                int first = nums[low];
                int count = map.get(first);
                --count;
                if (count == 0) map.remove(first);
                else map.put(first, count);
                ++low;
                maxDiff = Math.max(Math.abs(map.lastKey() - cur), Math.abs(map.firstKey() - cur));
            }
            res = Math.max(res, i - low + 1);
        }
        return res;
    }
}