class LongestCommonPrefix {
    //https://leetcode.com/problems/longest-common-prefix/submissions/
    public String longestCommonPrefix(String[] strs) {
        String ans = "";
        
        int i=0;
        while(allSame(strs, i)){
            ans = ans + strs[0].toCharArray()[i];
            i++;
        }
            
        return ans;
    }
    
    private boolean allSame(String[] strs, int index){
        char c;
        if(strs[0].length() > index){
            c = strs[0].toCharArray()[index];
        }else{
            return false;
        }
        
        for(int i=1;i<strs.length;i++){
            if(strs[i].length() <= index || strs[i].toCharArray()[index] != c){
                return false;
            }
        }
        
        return true;
    }
}
