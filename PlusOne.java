class PlusOne {
    //https://leetcode.com/problems/plus-one/submissions/
    public int[] plusOne(int[] digits) {
        int carry = 0;
        boolean needNew = true;
        int i =0;
        while(i < digits.length){
            if(digits[i] != 9){
                needNew = false;
                break;
            }
            i++;
        }
        
        int[] ans;
        int length = digits.length;
        if(needNew){
            ans = new int[length + 1];
        }else{
            ans = new int[length];
        }
        
        int j = ans.length - 1;
        for(i = digits.length -1; i>=0;i--){
            if( i == digits.length - 1){
                int n = digits[i] + 1;
                if(n >9){
                    carry = 1;
                    ans[j] = 0;
                }else{
                    ans[j] = n;
                }
            }else{
                int n = digits[i] + carry;
                if(n >9){
                    carry = 1;
                    ans[j] = 0;
                }else{
                    ans[j] = n;
                    carry = 0;
                }
            }
            j--;
        }
        
        if(carry == 1){
            ans[0] = 1;
        }
        return ans;
    }
}
