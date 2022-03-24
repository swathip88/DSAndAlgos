class GCDStrings {
    //https://leetcode.com/problems/greatest-common-divisor-of-strings/submissions/
    public String gcdOfStrings(String str1, String str2) {
        String origStr1 = str1;
        String origStr2 = str2;
        
        if(str1.length() < str2.length()){
            String temp = str2;
            str2 = str1;
            str1 = temp;
        }
        
        if(!initialCheck(str1, str2)){
            return "";
        }
        
        while(str1.contains(str2) && !str1.isEmpty() && !str2.isEmpty()){
            str1 = str1.replaceAll(str2, "");
            if(str1.length() < str2.length()){
                String temp = str2;
                str2 = str1;
                str1 = temp;
            }
        }
        
        if(str1.equals("")){
            return str2;
        }
        if(str2.equals("")){
            return str1;
        }
        
        return "";
    }
    
    private boolean initialCheck(String str1, String str2){
        for(int i=0;i<str2.length();i++){
            if(str1.charAt(i) != str2.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
