//https://leetcode.com/problems/reverse-integer/submissions/

class Solution {
    public int reverse(int x) {
        
        
        int a = x;
        if(a<=Integer.MIN_VALUE){
            return 0;
        }
        if(x<0){
            a = -a;
        }
        
        long res = 0;
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
        
        
        if (res > Integer.MAX_VALUE) {
            return 0;
        }
        
        if(x<0){
            res = -res;
        }
        
        return (int)res;
    }
}
