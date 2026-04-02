class MinStack {
    private Deque<Integer>dataStack;
    private Deque<Integer>minStack;
    
    public MinStack() {
        dataStack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();       
    }
    
    public void push(int val) {
        dataStack.push(val);
        if (minStack.isEmpty()||minStack.peek()>=val){
            minStack.push(val);
        }
    }
    
    public void pop() {
        int removed=dataStack.pop();
        if (removed==minStack.peek()){
            minStack.pop();
        }
        
    }
    
    public int top() {
        return dataStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */