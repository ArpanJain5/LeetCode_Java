class Solution {
    public int minOperations(int[] nums, int k) {
        int count=0; 
        int xor=0;
        for(int num:nums)
        {
            xor=xor^num;
        }
        while(k>0 || xor>0)
        {
            if(k%2!=xor%2)
            {
                count++;
            }
            k/=2;
            xor/=2;
        }
        return count;
    }
}