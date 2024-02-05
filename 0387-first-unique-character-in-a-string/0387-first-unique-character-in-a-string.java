class Solution {
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> cnt = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            cnt.put(s.charAt(i), cnt.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = 0; i < n; i++) {
            if (cnt.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}