class Solution {
    List<List<String>> ans=new ArrayList<>();
    public boolean isPalindrome(String s){
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)!=s.charAt(n-i-1))
                return false;
        }
        return true;
    }
    public void palpar(List<String> l,String s,int k){
        if(k+1==s.length()){
            ans.add(l);
            return;
        }
        for(int i=k+1;i<s.length();i++){   
            String ns=s.substring(k+1,i+1);
            if(isPalindrome(ns)){
                List<String > nl=new ArrayList<>(l);
                nl.add(ns);
                palpar(nl,s,i);
            }
        }
    }
    public List<List<String>> partition(String s) {
        palpar(new ArrayList<>(),s,-1);
        return ans;
    }
}