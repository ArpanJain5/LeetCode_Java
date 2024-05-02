import java.util.HashSet;
class Solution {
    public int findMaxK(int[] nums) {
        int k = -1;
        HashSet<Integer> numsSet = new HashSet<>();
        for (int num : nums) {
            numsSet.add(num);
        }
        for (int n : nums) {
            if (n > 0) {
                if (n > k && numsSet.contains(-n)) {
                    k = n;
                }
            }
        }
        return k;
    }
}