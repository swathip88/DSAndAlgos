class AddBinary {
    //https://leetcode.com/problems/add-binary/submissions/
    public String addBinary(String a, String b) {
        char[] arr1 = a.toCharArray();
        char[] arr2 = b.toCharArray();
        String ans = "";
        char carry = '0';
        int i= arr1.length -1;
        int j = arr2.length -1;
        while(i>=0 && j>=0){
            
            if(arr1[i] == arr2[j]){
                if(carry == '1' && arr1[i] == '1'){
                    ans="1" + ans;
                    
                }else if(carry == '1' && arr1[i] == '0'){
                    ans = "1" + ans;    
                    carry = '0';
                }else if(carry=='0' && arr1[i] == '1'){
                    ans = "0" + ans;
                    carry = '1';
                }else if(carry=='0' && arr1[i] == '0'){
                     ans = "0" + ans;
                    carry = '0';
                }
             }
            else{
                if(carry == '1'){
                    ans = "0" + ans;
                }else{
                    ans = "1" + ans;
                }
            }
            i--;
            j--;
        }
        if(i >=0){
            while(i>=0){
                char c = arr1[i];
                if(c == '0' && carry == '1'){
                    ans = "1" + ans;
                    carry = '0';
                }else if (c == '0' && carry == '0'){
                    ans = "0" + ans;
                }
                else if (c == '1' && carry == '1'){
                    ans = "0" + ans;
                    
                }else if(c =='1' && carry == '0'){
                    ans = "1" + ans;
                    
                }
                i--;
            }
        }
        
        if(j >=0){
            while(j>=0){
                char c = arr2[j];
                if(c == '0' && carry == '1'){
                    ans = "1" + ans;
                    carry = '0';
                }else if (c == '0' && carry == '0'){
                    ans = "0" + ans;
                }
                else if (c == '1' && carry == '1'){
                    ans = "0" + ans;
                    
                }else if(c =='1' && carry == '0'){
                    ans = "1" + ans;
                    
                }
                j--;
            }
        }
        
        if(carry == '1'){
            ans = "1" + ans;
        }
        return ans;
    }
}
                          
