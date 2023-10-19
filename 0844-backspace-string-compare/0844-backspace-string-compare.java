class Solution {
    public static boolean backspaceCompare(String s, String t) {
    Stack<Character> stackS = new Stack<>();
    Stack<Character> stackT = new Stack<>();
    char[] arrayS = s.toCharArray();
    char[] arrayT = t.toCharArray();
        for (int i = 0; i < arrayS.length; i++) {
            if (arrayS[i] != '#') {
                stackS.push(arrayS[i]);
            } else if (!stackS.isEmpty()) {
                stackS.pop();
            }
        }
        for (int i = 0; i < arrayT.length; i++) {
            if (arrayT[i] != '#') {
                stackT.push(arrayT[i]);
            } else if (!stackT.isEmpty()) {
                stackT.pop();
            }
        }
        return isSameStack(stackS, stackT);
    }
    public static boolean isSameStack(Stack<Character> stack1, Stack<Character> stack2) {
        boolean flag = true;
        if (stack1.size() != stack2.size()) {
            flag = false;
            return flag;
        }
        while (stack1.empty() == false) {
            if (stack1.peek() == stack2.peek()) {
                stack1.pop();
                stack2.pop();
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }
}