public String convert(String s, int numRows) {
        //https://leetcode.com/problems/zigzag-conversion/submissions/
        if(numRows<=1) {
            return s;
        }
        String[] arr = new String[numRows];
        for(int i=0;i<numRows;i++){
            arr[i] = "";
        }
        int j = 0;
        boolean goDown = true;
        for(int i=0;i<s.length();i++){
            arr[j] = arr[j] + s.charAt(i);
            if(j==0){
                goDown = true;

            }else if (j== numRows-1){
                goDown = false;
            }
            if(goDown){
                j++;
            }else{
                j--;
            }

        }

        String res = "";
        for(int i =0;i<arr.length;i++){
            res += arr[i];
        }

        return res;
                   
    }
