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
}
