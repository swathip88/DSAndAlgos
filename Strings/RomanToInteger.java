class RomanToInteger {
    //https://leetcode.com/problems/roman-to-integer/submissions/
    public int romanToInt(String s) {
        
        int prevVal = 0;
        int curVal = 0;
        int res = 0;
        for(int i=s.length()-1;i>=0;i--){
            
            char c = s.charAt(i);
            if(c == 'I'){
                curVal = 1;
            }else if (c == 'V'){
                curVal = 5;
            }else if (c == 'X'){
                curVal = 10;
            }else if (c == 'L'){
                curVal = 50;
            }else if (c == 'C'){
                curVal = 100;
            }else if (c == 'D'){
                curVal = 500;
            }else if (c == 'M'){
                curVal = 1000;
            }
            if(curVal < prevVal){
                    res = res - curVal;
                    
            }else{
                    res = res + curVal;
            }
            prevVal = curVal;
        }
        return res;
    }
}
