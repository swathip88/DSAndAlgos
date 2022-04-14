class OneEditDistance {
    //https://leetcode.com/problems/one-edit-distance/submissions/
    public boolean isOneEditDistance(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        
        if(Math.abs(s.length()- t.length()) > 1){
            return false;
        }else if(s.equals(t)){
            return false;
        }
        boolean isSame = (s.length() == t.length());
        
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        
        int start1 = 0;
        int start2 = 0;
        
        while(start1 < s.length() && start2 < t.length()){
            if(arr1[start1] == arr2[start2]){
                start1++;
                start2++;
            }else{
                break;
            }
        }
        
        if(isSame){
            start1++;
            start2++;
        }else{
            if(s.length() > t.length()){
                start1++;
            }else{
                start2++;
            }
        }
        
        while(start1 < s.length() && start2 < t.length()){
            if(arr1[start1] == arr2[start2]){
                start1++;
                start2++;
            }else{
                return false;
            }
        }
        
        return true;
    }
}
