class NeedleInHaystack {
    //https://leetcode.com/problems/implement-strstr/submissions/
    public int strStr(String haystack, String needle) {
        if(haystack == null || needle == null){
            return -1;
        }
        if(needle.equals("")){
            return 0;
        }
        
        int length = needle.length();
        for(int i=0;i<haystack.length();i++){
            
            if((i + length) <=haystack.length()){
                if(haystack.substring(i, i + length).equals(needle)){
                    return i;
                }
            }
        }
        
        return -1;
    }
}
