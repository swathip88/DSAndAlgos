class MaxStack {
    //https://leetcode.com/problems/max-stack/submissions/
    Stack<Integer> stack;
    Stack<Integer> maxStack;
    
    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }
    
    public void push(int x) {
        stack.push(x);
        int max = maxStack.isEmpty() ? x: maxStack.peek();
        maxStack.push(Math.max(x, max));
    }
    
    public int pop() {
        maxStack.pop();
        return stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int peekMax() {
        return maxStack.peek();
    }
    
    public int popMax() {
        int max = peekMax();
        Stack<Integer> temp = new Stack<>();
        while(top() != max){
            temp.push(pop());
        }
        pop();
        
        while(!temp.isEmpty()) push(temp.pop());
        return max;
    }
    
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
