class LengthOfLastWord {
    //https://leetcode.com/problems/length-of-last-word/submissions/
    public int lengthOfLastWord(String s) {
        int count = 0;
        char[] arr = s.toCharArray();
        
        int i= arr.length -1;
        
        while(i>=0 && arr[i] == ' '){
            i--;
        }
        
        while(i>=0 && arr[i] != ' '){
            i--;
            count++;
        }
        
        return count;
    }
}
