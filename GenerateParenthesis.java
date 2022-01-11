class GenerateParenthesis {
    //https://leetcode.com/problems/generate-parentheses/submissions/
  
    public List<String> generateParenthesis(int n) {
        
        List<String> ans = new ArrayList<>();
        
        generateCombos(ans, "", 0,0,n);
        return ans;
    }
    
    private void generateCombos(List<String> ans, String str, 
                           int noOfOpen, int noOfClosed, int n){
        if(noOfOpen == n && noOfClosed == n){
            ans.add(str);
            return;
        }
        
        if(noOfOpen <n){
            generateCombos(ans, str + "(", noOfOpen+ 1, noOfClosed, n);
        }
        if(noOfClosed< noOfOpen){
            generateCombos(ans, str + ")", noOfOpen, noOfClosed+1, n);
        }
        
    }
}
