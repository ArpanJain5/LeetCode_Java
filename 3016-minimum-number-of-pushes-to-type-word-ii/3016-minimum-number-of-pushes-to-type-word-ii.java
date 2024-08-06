class Solution {
    public int minimumPushes(String word) {
        int arr[] = new int[26];
		for (char ch : word.toCharArray()) {
			arr[ch - 'a']--;
		}    
		Arrays.sort(arr);
        int count=0;
		for (int i = 0; i < 26; i++) {
			count -= arr[i] * (i / 8 + 1);
		}
		return count;
    }
}