class Solution {
    public String reverseParentheses(String s) {
        StringBuilder str=new StringBuilder();
        Stack<Character>stack=new Stack<>();
        for(int i=0;i<s.length();i++){
           char ch=s.charAt(i);
           if(ch==')'){
            char ch1=stack.pop();
            Queue<Character>q=new LinkedList<>();
            while(ch1!='('&&!stack.isEmpty()){
                
                q.add(ch1);
                ch1=stack.pop();
            }
            while(!q.isEmpty()){
                stack.push(q.remove());
            }
           }else{
             stack.push(ch);
           }
        }
        while(!stack.isEmpty()){
            str.append(stack.pop());
        }
        return str.reverse().toString();
    }
}