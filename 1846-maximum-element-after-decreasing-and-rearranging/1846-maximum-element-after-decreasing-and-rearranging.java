class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        if(arr[0] != 1){
            int i = 0;
            for(i=0; i<arr.length; i++){
                if(arr[i] == 1){
                    break;
                }
            }
            if(i == arr.length) arr[0] = 1;
            else{
                int temp = arr[i];
                arr[i] = arr[0];
                arr[0] = temp;
            }  
        } 
        for(int i=1; i<arr.length; i++){
            if(Math.abs(arr[i]-arr[i-1]) > 1){
                arr[i] = arr[i-1]+1;
            }
        }  
        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            max = Math.max(max, arr[i]);
        }     
        return max;
    }
}