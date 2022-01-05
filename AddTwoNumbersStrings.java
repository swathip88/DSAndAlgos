class AddTwoNumbersStrings {
    //https://leetcode.com/problems/add-strings
    public String addStrings(String num1, String num2) {
        
        int l1 = num1.length();
        int l2 = num2.length();

        int i = l1 - 1;
        int j = l2 - 1;
        int carry = 0;
        String result = "";
        while(i >=0 && j >=0){
            int no1 = Integer.parseInt(String.valueOf(num1.charAt(i)));
            int no2 = Integer.parseInt(String.valueOf(num2.charAt(j)));
            int sum = no1 + no2 + carry;
            if(sum >= 10){
                sum = sum - 10;
                carry = 1;
            }else{
                carry = 0;
            }
            result = sum + result;
            i--;
            j--;
        }

        if(i>=0){
            while(i>=0){
                int no1 = Integer.parseInt(String.valueOf(num1.charAt(i)));
                int sum = no1 + carry;
                if(sum >= 10){
                    sum = sum - 10;
                    carry = 1;
                }else{
                    carry = 0;
                }
                result = sum + result;
                i--;
            }
        }

        if(j>=0){
            while(j>=0){
                int no1 = Integer.parseInt(String.valueOf(num2.charAt(j)));
                int sum = no1 + carry;
                if(sum >= 10){
                    sum = sum - 10;
                    carry = 1;
                }else{
                    carry = 0;
                }
                result = sum + result;
                j--;
            }
        }

        if(carry == 1){
            result = "1" + result;
        }
        
        return result;
    }
}
