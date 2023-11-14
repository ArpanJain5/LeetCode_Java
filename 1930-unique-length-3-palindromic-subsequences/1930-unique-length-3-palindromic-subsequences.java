class Solution {
    public int countPalindromicSubsequence(String s) {
        int n=s.length();
        Character arr[]={'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
       HashMap<Character,Integer> firstOcc= new HashMap<>();
       HashMap<Character,Integer> lastOcc= new HashMap<>();
       for(int i=0;i<n;i++){ 
           if(!firstOcc.containsKey(s.charAt(i))){
               firstOcc.put(s.charAt(i),i);
           }
       }
        for(int i=n-1;i>=0;i--){ 
           if(!lastOcc.containsKey(s.charAt(i))){
               lastOcc.put(s.charAt(i),i);
           }
       }
int cnt=0;
       for(int i=0;i<26;i++){     
          int st=-1,end=-1;
          if(firstOcc.get(arr[i])==null) continue;
          st=firstOcc.get(arr[i]);
          end=lastOcc.get(arr[i]);
          HashSet<Character> h= new HashSet<>();
            for(int j=st+1;j<end;j++){ 
                 if(!h.contains(s.charAt(j))){ 
                     cnt++;h.add(s.charAt(j));
                 } 
            }
       }
return cnt;
    }
}