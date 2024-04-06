class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++)
        {
            if(s.charAt(i) == '(') 
                stack.push(i);
            else if(s.charAt(i) == ')')
            {
                if(!stack.isEmpty() && s.charAt((int)stack.peek()) == '(')
                {
                    stack.pop();
                }
                else 
                    stack.push(i);
            }
            else 
                continue;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1 ; i >= 0 ; i--)
        {
            if(!stack.isEmpty() && (int)stack.peek() == i) 
            {
                stack.pop();
                continue;
            }
            else 
                sb.append(s.charAt(i));
        }
        return sb.reverse().toString();
    }
}