class Solution {
    public int rangeSum(int[] nums, int p, int le, int ri) {
        int n = nums.length;
        long[] subArraySum = new long[(n * (n + 1)) / 2];
        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];
        int index = 0;
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        for (int i = 0; i < n; i++) {
            subArraySum[index++] = prefixSum[i];
            for (int j = 0; j < i; j++) {
                subArraySum[index++] = prefixSum[i] - prefixSum[j];
            }
        }
        Arrays.sort(subArraySum);
        long sum = 0;
        int mod = 1_000_000_007; 
        for (int i = le - 1; i < ri; i++) {
            sum = (sum + subArraySum[i]) % mod;
        }  
        return (int) sum;
    }
}