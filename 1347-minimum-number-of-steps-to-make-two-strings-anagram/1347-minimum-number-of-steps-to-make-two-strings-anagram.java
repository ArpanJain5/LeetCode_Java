class Solution {
    public int minSteps(String s, String t) {
        int[] sFreq = new int[26];
        int[] tFreq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sFreq[s.charAt(i) - 'a']++;
            tFreq[t.charAt(i) - 'a']++;
        }
        int steps = 0;
        for (int i = 0; i < 26; i++) {
            int step = sFreq[i] - tFreq[i];
            if (step > 0) {
                steps += step;
            }
        }
        return steps;
    }
}