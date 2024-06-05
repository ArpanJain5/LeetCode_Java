class Solution {
    public  int checkP(char k,String word) {
		int count=0;
		for(char c:word.toCharArray()) {
			if(c==k)
				count++;
		}
			return count;
	}
    public List<String> commonChars(String[] words) {
        Map<Character,Integer> mp=new HashMap<>();
		 Map<Character,Integer> mp2=new HashMap<>();

		 for(char c:words[0].toCharArray())
			 mp.put(c, mp.getOrDefault(c, 0)+1);
	
		 for(Character k:mp.keySet()) {
			 int x=0;
			 for(String word:words) {
			   x=checkP(k,word);
			   mp.put(k, Math.min(x, mp.get(k)));
			   }
			
		 }
		 List<String> ans=new LinkedList<>();
		 for(Character k:mp.keySet()) {
			 for(int i=0;i<mp.get(k);i++) {
				 ans.add(Character.toString(k));
			 }
				
		 }
		return ans;	 
    }
}