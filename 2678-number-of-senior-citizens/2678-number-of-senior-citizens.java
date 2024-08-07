class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for (String detail : details) {
            String ageSubstring = detail.substring(11, 13);
            int age = Integer.parseInt(ageSubstring);
            if (age > 60) {
                count++;
            }
        }
        return count;
    }
}