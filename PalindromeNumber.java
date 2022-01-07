class PalindromeNumber {
    //https://leetcode.com/problems/palindrome-number/submissions/
    public boolean isPalindrome(int x) {
        if(x <0){
            return false;
        }
        int a = x;
        int res = 0;
        while(a!=0){
            int rem = a%10;
            res = (res*10) + rem;
            if(a>=10){
                a = a/10;
            }
            else{
                break;
            }
        }
        if(res == x){
            return true;
        }else{
            return false;
        }
    }
}
