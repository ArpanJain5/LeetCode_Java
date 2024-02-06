class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res=new ArrayList<>();
        HashMap<String, List<String>> map=new HashMap<>();
        for(String str:strs){
            char[] character=str.toCharArray();
            Arrays.sort(character);
            String sortedString=new String(character);
            if(!map.containsKey(sortedString)){
                map.put(sortedString, new ArrayList<>());
            }
            map.get(sortedString).add(str);     
        }
        res.addAll(map.values());
        return res;
    }
}