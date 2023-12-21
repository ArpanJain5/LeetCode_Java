class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int len = points.length;
        int arr[] = new int[len];
        int j=0;
        for(int point[]:points)
            arr[j++]=point[0];
        int maxDiff = 0;
        Arrays.sort(arr);
        for(int i=1;i<arr.length;i++)
            maxDiff=Math.max(maxDiff,arr[i]-arr[i-1]);
        return maxDiff;
    }
}