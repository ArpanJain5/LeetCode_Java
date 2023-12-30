class Solution {
    public boolean makeEqual(String[] words) {
        int n = words.length;
        HashMap<Character,Integer> map = new HashMap<>();
        for(String str : words){
            for(int i=0 ; i<str.length();i++){
                if(map.containsKey(str.charAt(i))){
                    int a = map.get(str.charAt(i));
                    a++;
                    map.put(str.charAt(i), a);
                }else{
                    map.put(str.charAt(i), 1);
                }
            }
        }
        Set<Character> keys = map.keySet();
        for (Character k : keys) {
            if(map.get(k) % n != 0){
                return false;
            }
        }
        return true;
        
    }
}