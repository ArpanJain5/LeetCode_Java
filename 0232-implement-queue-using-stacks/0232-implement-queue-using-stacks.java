class MyQueue {
    Stack<Integer> stack;
    Stack<Integer> revStack;
    public MyQueue() {
        stack = new Stack<>();
        revStack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
    }
    
    public int pop() {
        if(!empty()){
        while(!stack.isEmpty()){
            revStack.push(stack.pop());
        }
        int v = revStack.pop();
        while(!revStack.isEmpty()){
            stack.push(revStack.pop());
        }
        return v;
        }
        return 0;
    }
    
    public int peek() {
        if(!empty()){
        while(!stack.isEmpty()){
            revStack.push(stack.pop());
        }
        int v = revStack.peek();
        while(!revStack.isEmpty()){
            stack.push(revStack.pop());
        }
        return v;
        }
        return 0;
    }
    
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */