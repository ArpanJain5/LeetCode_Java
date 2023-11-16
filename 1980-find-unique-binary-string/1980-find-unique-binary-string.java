class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int[] arr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) arr[i] = Integer.parseInt(nums[i], 2);
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] > 1) {
                String res = Integer.toBinaryString(arr[i] - 1);
                StringBuilder sb = new StringBuilder();
                while(sb.length() + res.length() < nums[0].length()) sb.append("0");
                sb.append(res);
                return sb.toString();
            }
        }
        if (arr[0] != 0) {
            StringBuilder sb = new StringBuilder();
            while(sb.length() < nums[0].length()) sb.append("0");
            return sb.toString();
        }
        String res = Integer.toBinaryString(arr[arr.length - 1] + 1);
        StringBuilder sb = new StringBuilder();
        while(sb.length() + res.length() < nums[0].length()) sb.append("0");
        sb.append(res);
        return sb.toString();
    }
}