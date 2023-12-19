class Solution {
    private int helper(int[][] img, int x, int y){
        int sum=0, count=0;
        for(int i=-1; i<=1; i++){
            for(int j=-1; j<=1; j++){
                if(x+i<0 ||x+i>=img.length || y+j<0 ||y+j>=img[0].length){
                    continue;
                }
                count++;
                sum += img[x+i][y+j];
            }
        }
        return sum/count;
    }
    public int[][] imageSmoother(int[][] img) {
        int[][] res= new int[img.length][img[0].length];
        for(int i=0; i<img.length; i++){
            for(int j=0; j<img[0].length; j++){
                res[i][j] = helper(img, i, j);
            }
        }
        return res;
    }
}