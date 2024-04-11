class Solution {
    public String removeKdigits(String nums, int k) {
        int n = nums.length();
        if(k == n) return "0"; 
        Stack<Character> stack = new Stack<>();
        int count = 0;
        while(count < n){
            while(k>0  && !stack.isEmpty() && stack.peek() > nums.charAt(count)){
                stack.pop();
                k--;
            }
            stack.push(nums.charAt(count));
            count++;
        }
        while(k>0){
            stack.pop();
            k--;
        }
        StringBuilder str = new StringBuilder();
        while(!stack.isEmpty()){
            str.append(stack.pop());
        }
        str.reverse();
        while(str.length() > 1 && str.charAt(0) =='0'){
            str.deleteCharAt(0);
        }
        return str.toString();
    }
}