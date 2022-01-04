class MyQueue {
    //https://leetcode.com/problems/implement-queue-using-stacks/
    
    Stack<Integer> s1 = null;
    Stack<Integer> s2 = null;
    
    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int x) {
        s1.push(x);
    }
    
    public int pop() {
        if(s2.empty()){
            if(s1.empty()) {
                System.out.println("Error");
                return -1000;
            }
            while(!s1.empty()){
                s2.push(s1.pop());
            }
            return s2.pop();
        }else{
            return s2.pop();
        }
    }
    
    public int peek() {
        if(s2.empty()){
            if(s1.empty()) {
                System.out.println("Error");
                return -1000;
            }
            while(!s1.empty()){
                s2.push(s1.pop());
            }
            return s2.peek();
        }else{
            return s2.peek();
        }
    }
    
    public boolean empty() {
        return s1.empty() && s2.empty();
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
