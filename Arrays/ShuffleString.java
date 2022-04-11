class ShuffleString {
    //https://leetcode.com/problems/shuffle-string/submissions/
    public String restoreString(String s, int[] indices) {
        char[] arr = new char[s.length()];
        
        for(int i=0;i<indices.length;i++){
            arr[indices[i]] = s.charAt(i); 
        }
        
        return String.valueOf(arr);
    }
}
