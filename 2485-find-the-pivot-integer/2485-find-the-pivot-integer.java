class Solution {
    public int pivotInteger(int n) {
        int sum1 = 1;
        int sum2 = n;
        int start = 1;
        int end = n;
        while(start <= end){
            if(sum1 == sum2 && start == end){
                return start;
            }
            else if(sum1 < sum2){
                start++;
                sum1 += start;
            }
            else if(sum1 > sum2){
                end--;
                sum2 += end;
            }
            else{
                start++;
                end--;
                sum1 += start;
                sum2 += end; 
            }
        }
        return -1;
    }
}