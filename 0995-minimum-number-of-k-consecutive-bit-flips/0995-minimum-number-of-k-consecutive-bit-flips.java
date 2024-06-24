class Solution {
    public int minKBitFlips(int[] nums, int k) {
         int n=nums.length;
         Queue<Integer> ms=new LinkedList<>();
         int ans=0;
         for(int i=0;i<n;i++){
            if((nums[i]==0 && ms.size()%2==0)||(nums[i]==1 && ms.size()%2==1)){
                ans++;
                if(i+k>n){
                    return -1;
                }
                ms.add(i+k-1);
            }
            if(ms.size()>0&&ms.peek()==i){
                    ms.remove();
            }
             
         }
         return ans;
    }
}