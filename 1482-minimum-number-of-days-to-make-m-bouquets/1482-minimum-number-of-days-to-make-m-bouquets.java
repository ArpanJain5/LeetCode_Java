class Solution {
    public boolean possible(int[]nums ,int day , int m , int k ){
      
        int count = 0;
        int NoB = 0;

        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] <= day){
                count++;
            }else{
                NoB += (count/k);
                count = 0;
            }
        }
        NoB += (count/k);
        return NoB >= m ;
    }


    public int minDays(int[] nums, int m, int k) {
        long val = (long) m*k;
        if(val > nums.length){
            return -1;
        }
        int low = Integer.MAX_VALUE;     
        int high = Integer.MIN_VALUE; 

        for(int i = 0 ; i < nums.length ; i++){
            low = Math.min( nums[i] , low);
            high = Math.max ( nums[i] , high);
        }    
        int ans = 0;   
        while(low <= high){
            int mid = (high+low)/2;
            if( possible(nums , mid , m , k )){
                ans= mid;
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return ans;
    }
}