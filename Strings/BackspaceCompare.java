class BackspaceCompare {
    //https://leetcode.com/problems/backspace-string-compare/solution/
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '#'){
                if(s1.isEmpty()){
                    
                }else{
                    s1.pop();
                }
            }else{
                s1.add(s.charAt(i));
            }
        }
        
        for(int i=0;i<t.length();i++){
            if(t.charAt(i) == '#'){
                if(s2.isEmpty()){
                    
                }else{
                    s2.pop();
                }
            }else{
                s2.add(t.charAt(i));
            }
        }
        
        String newS = "";
        String newT = "";
        
        while(!s1.empty()){
            newS = newS + s1.pop();
        }
        
        while(!s2.empty()){
            newT = newT + s2.pop();
        }
        return newS.equals(newT);
    }
}
