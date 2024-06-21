class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int i = 0, j = 0, ans = 0, sum = 0;
        while(j < customers.length){
            if(grumpy[j] == 1){
                sum += customers[j];
            }
            if(j - i + 1 != minutes){
                j++;
            }else if(j - i + 1 == minutes){
                ans = Math.max(ans,sum);
                if(grumpy[i] == 1){
                    sum -= customers[i];
                }
                i++;
                j++;
            }
        }
        for(var it = 0; it < customers.length; it++){
            if(grumpy[it] == 0){
                ans += customers[it];
            }
        }
        return ans;
    }
}