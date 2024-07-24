class Solution {
    public int[] sortJumbled(int[] mapping, int[] nums) {
        return Arrays.stream(nums)
                .boxed()
                .sorted(Comparator.comparingInt(num -> buildJumbled(mapping, num))).
                mapToInt(i -> i).
                toArray();
    }

    public static int buildJumbled(int[] mapping, int num) {
        int devisor = (int) Math.pow(10, String.valueOf(num).length());
        int jumbled = 0;
        while(devisor != 1) {
            devisor /= 10;
            jumbled += (devisor * mapping[num / devisor]);
            num -= devisor * (num / devisor);
        }

        return jumbled;
    }
}