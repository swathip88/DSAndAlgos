class MinimumWindowSubstring {
    //https://leetcode.com/problems/minimum-window-substring/submissions/
    public String minWindow(String s, String t) {
     String result = "";

        if(t.length() > s.length()){
            return "";
        }
        int[] freq1 = new int[256];
        int[] freq2 = new int[256];
        
        for(char c: t.toCharArray()){
            freq1[c]++;
        }
        
        int len= s.length() + 1;
        int l = 0;
        int count = 0;
        char[] arr = s.toCharArray();
        
        for(int i=0;i<arr.length;i++){
            freq2[arr[i]]++;
            
            if(freq1[arr[i]] !=0 && (freq2[arr[i]] <= freq1[arr[i]])){
                count ++;
            }
            
            if(count == t.length()){
                //Remove unwanted and repeated characters from the start
                while(freq2[arr[l]] > freq1[arr[l]] || freq1[arr[l]] ==0){
                    //repeated character at the start
                    if(freq2[arr[l]]> freq1[arr[l]]){
                        freq2[arr[l]]--;
                    }
                    l++;
                }
                
                if(len > i - l +1){
                    len = i-l+1;
                    result = s.substring(l, l+len);
                }
                
            }
        }
        
        return result.length()==0?"":result;
    }
    
}
