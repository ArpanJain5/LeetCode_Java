class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int[]res = new int[n];
        int sum = 0 , prefix =0 , suffix = 0;
        for(int a: nums) sum+= a;   
        for(int i=0;i<n;++i){
            suffix = sum- prefix; 
            prefix += nums[i];
            res[i]= (nums[i]*i - prefix) + (suffix- nums[i]*(n-i-1));
        }
        return res;
    }
}