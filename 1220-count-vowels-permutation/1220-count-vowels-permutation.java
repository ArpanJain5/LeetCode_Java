class Solution {
    private int add(int a,int b){return (int)(((long)a+b)%1000000007);}
    public int countVowelPermutation(int n) {
        int dp[]=new int[5],j,res=0,a,e,i,o,u;
        for(j=0;j<5;j++) {
            dp[j] = 1;
        }
        for(j=0;j<(n-1);a=e=i=o=u=0,j++){             
            e=dp[0];             
            a=i=dp[1];;
            a=add(a,dp[2]); e=add(e,dp[2]); o=dp[2]; u=dp[2];        
            i=add(i,dp[3]); u=add(u,dp[3]);           
            a=add(a,dp[4]);   
            dp[0]=a; dp[1]=e; dp[2]=i; dp[3]=o; dp[4]=u;
        }
        for(j=0;j<5;j++){
            res=add(res,dp[j]);
        }
        return res;
    }
}