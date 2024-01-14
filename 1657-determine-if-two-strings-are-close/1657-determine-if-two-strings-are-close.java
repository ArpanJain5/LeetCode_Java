class Solution {
    public boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length())  return false;
        if (word1.equals(word2))  return true;
        int[] arr1 = new int[26];                    
        for (char c : word1.toCharArray())  arr1[c - 'a']++;
        int[] arr2 = new int[26];                  
        for (char c : word2.toCharArray()) {
            if (arr1[c - 'a'] == 0)                
                return false;
            arr2[c - 'a']++;
        }
        Arrays.sort(arr1);                      
        Arrays.sort(arr2);
        return Arrays.equals(arr1, arr2);
    }
}