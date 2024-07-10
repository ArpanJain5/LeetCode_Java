class Solution {
    public double averageWaitingTime(int[][] customers) {
        double time = 0;
        double ans = 0;
        int n = customers.length;
        for (int i = 0;i<n;i++) {
            if (time >customers[i][0]) {
                ans+=time-customers[i][0];
                time+=customers[i][1];
            }
            else {
                time+=customers[i][1]+(customers[i][0]-time);
            }
            ans+=customers[i][1];
            
        }
        return ans/n;
    }
}