class ValidPalindromeII {
    //https://leetcode.com/problems/valid-palindrome-ii/submissions/
    public boolean validPalindrome(String s) {
        char[] arr = s.toCharArray();
        int start= 0;
        int end = arr.length -1;
        while(start < end){
            if(arr[start] == arr[end]){
                start++;
                end--;
                
            }
            else{
                break;
            }
        }
        if(start >=end) return true;
        
        int i = start + 1;
        int j = end;
        while(i<j){
            if(arr[i] == arr[j]){
                i++;
                j--;
            }
            else{
                break;
            }
        }
        if(i >=j) return true;
        
        i = start;
        j = end - 1;
        while(i <j){
            if(arr[i] == arr[j]){
                i++;
                j--;
                
            }
            else{
                break;
            }
        }
        if(i >=j) return true;
        
         
        return false;
    }
}
