class Solution {
    public String frequencySort(String s){
        Map<Character, Integer> countMap = new HashMap<>();
        for(char c : s.toCharArray()){
            countMap.put(c,countMap.getOrDefault(c,0)+1);
        }
        List<Character> sortedChars = new ArrayList<>(countMap.keySet());
        Collections.sort(sortedChars, (a,b) -> countMap.get(b)-countMap.get(a));
        StringBuilder result = new StringBuilder();
        for(char c : sortedChars){
            result.append(String.valueOf(c).repeat(countMap.get(c)));
        }
        
        return result.toString();
    }
}