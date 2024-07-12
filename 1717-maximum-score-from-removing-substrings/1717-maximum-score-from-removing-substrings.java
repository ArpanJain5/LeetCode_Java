class Solution {
    public int maximumGain(String s, int x, int y) {
        if(x>y){
            return removal(s,'a','b',x,y);
        }
        else{
            return removal(s,'b','a',y,x);
        }
    }
    public int removal(String s, char first, char second,int gain1, int gain2){
        Stack<Character>st = new Stack<>();
        int ans = 0;
        for(int i=0;i<s.length();i++){
            if(!st.isEmpty() && st.peek()==first && s.charAt(i)==second){
                st.pop();
                ans = ans + gain1;
            }
            else{
                st.push(s.charAt(i));
            }
        }
        System.out.println(ans);
        return ans + secondremoval(st,gain2,first,second);
    }
    public int secondremoval(Stack<Character>st, int gain2, char first, char second){
        int ans = 0;
        String s = "";
        while(!st.isEmpty()){
            s = st.pop()+s;
        }

        for(int i=0;i<s.length();i++){
            if(!st.isEmpty() && st.peek()==second && s.charAt(i)==first){
                st.pop();
                ans = ans + gain2;
            }
            else{
                st.push(s.charAt(i));
            }
        }
        return ans;
    }
}