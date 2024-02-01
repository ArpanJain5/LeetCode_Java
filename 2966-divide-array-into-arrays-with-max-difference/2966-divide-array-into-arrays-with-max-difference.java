class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int[][] output = new int[nums.length/3][3];
        int y = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i+=3){
            if (nums[i+2] - nums[i] > k) return new int[0][0];
            y = i / 3;
            output[y][0] = nums[i];
            output[y][1] = nums[i+1];
            output[y][2] = nums[i+2];
        }
        return output;
    }
}