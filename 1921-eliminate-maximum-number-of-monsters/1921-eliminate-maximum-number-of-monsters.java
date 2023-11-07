class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
              int n = dist.length;
        int[] arrivalTimes = new int[n];
        for (int i = 0; i < n; i++) {
            arrivalTimes[i] = (dist[i] + speed[i] - 1) / speed[i];
        }
        Arrays.sort(arrivalTimes);
        int eliminated = 0;
        int currentTime = 0;
        for (int i = 0; i < n; i++) {
            if (arrivalTimes[i] <= currentTime) {
                return eliminated;
            }
            eliminated++;
            currentTime++;
        }
        return eliminated;
    }
}