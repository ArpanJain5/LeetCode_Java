class Solution {
    public int minimumOneBitOperations(int n) {
        int result = checkBaseCases(n);
        if(result > -1) return result; 
        int operations=0;
        while(n>0) {
            int mask=1;
            while(mask<n) {
                mask=mask<<1;
            }
            mask= mask>>1;
            operations += mask;
            n = mask^(mask>>1)^n;
            result = checkBaseCases(n);
            if(result > -1) return result+operations; 
        }
        return operations;
    }
    private int checkBaseCases(int n) {
        if(n == 0) return 0;
        if( n == 1) return 1;
        if((n&(n-1)) == 0) { 
            int power = (int)(Math.log(n)/Math.log(2));
            return (int)Math.pow(2, power+1) - 1;
        }
        int a = n<<1;
        if(a != 0 && (a&(a-1))==0) {
            int power = (int)(Math.log(n)/Math.log(2));
            return (int)Math.pow(2, power);
        }
        return -1;
    }
}