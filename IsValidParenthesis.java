class IsValidParenthesis {
    //https://leetcode.com/problems/valid-parentheses/submissions/
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        char[] arr = s.toCharArray();
        
        for(int i=0;i<arr.length;i++){
            char c = arr[i];
            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char poppedChar= stack.pop();
                
                if((c == '}' && poppedChar == '{')){
                    
                }
                else if((c == ')' && poppedChar == '(')){
                    
                }
                else if((c == ']' && poppedChar == '[')){
                    
                }else{
                    return false;
                }
                
            }
            
        }
        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }
    }
}
