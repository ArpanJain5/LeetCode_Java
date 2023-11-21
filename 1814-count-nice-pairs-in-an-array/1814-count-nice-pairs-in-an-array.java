class Solution {
    public int countNicePairs(int[] nums) {
        final int MOD = 1000000007;
        int count = 0;
        HashMap<Long, Integer> freqMap = new HashMap<>();
        for (int num : nums) {
            long revNum = reverseNumber(num);
            long diff = (long)num - revNum;
            freqMap.put(diff, freqMap.getOrDefault(diff, 0) + 1);
        }
        for (long key : freqMap.keySet()) {
            int freq = freqMap.get(key);
            if (freq > 1) {
                count = (int)((count + ((long)freq * (freq - 1) / 2)) % MOD);
            }
        }
        return count;
    }
    private long reverseNumber(int num) {
        long rev = 0;
        while (num > 0) {
            int digit = num % 10;
            rev = rev * 10 + digit;
            num /= 10;
        }
        return rev;
    }
}