class Solution {
    public void sortColors(int[] nums) {
        int a=0;
        int b=nums.length-1;
        int c=0;
        while(c<=b){
            if(nums[c]==0){
                nums[c]=1;
                nums[a++]=0;
            }else if(nums[c]==2){
                while(b>c&& nums[b]==2){
                    b--;
                }
                if(nums[b]==0){
                    nums[c]=1;
                    nums[a++]=0;
                    nums[b--]=2;
                }else{
                    nums[c]=1;
                    nums[b--]=2;
                }
            }
            c++;
        }
    }
}