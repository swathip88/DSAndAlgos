class ValidPalindrome {
    //https://leetcode.com/problems/valid-palindrome/submissions/
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] arr = s.toCharArray();
        int start = 0;
        int end = arr.length - 1;
        
        while(start < end){
            while(start < end && !isAlphaNum(arr[start])){
                start ++;
            }
            while(start < end && !isAlphaNum(arr[end])){
                end --;
            }
            
            if(arr[start] != arr[end]){
                return false;
            }
            start++;
            end --;
        }
        
        return true;
    }
    
    boolean isAlphaNum(char c)
    {
        if( (48<=c && c<=57) || (65<=c && c<=90) || (97<=c && c<=122)) 
            return true;
        else
            return false;
    }
}
