class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {  
        int ans = 0;
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<s.length();i++){
            if(hm.containsKey(s.charAt(i)))
             ans = Math.max(ans, i-(int)hm.get(s.charAt(i))-1);
            else 
             hm.put(s.charAt(i),i);
        }
        if(hm.size()==s.length())
            return -1;
        return ans;
    }
}