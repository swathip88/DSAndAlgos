class WordValidAfterSubstitutions {
    //https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/submissions/
    public boolean isValid(String s) {
        while(true){
            String t = s.replace("abc", "");
            
            if(t.equals("")){
                return true;
            }
            if(t.equals(s)){
                return false;
            }
            s = t;
        }
    }
    
    //Another solution
    public boolean isValid2(String s) {
        Stack<Character> st = new Stack<>();
        
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            
            if(ch == 'a' || ch == 'b'){
                st.push(ch);
            }
            else{
                if(st.size() >= 2 && st.pop() == 'b' && st.pop() == 'a'){
                    // no issue
                }
                else{
                    return false;
                }
            }
        }
        
        return st.size() == 0;
    }
}
