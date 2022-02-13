class LongestSubStringWithOutRepeatingChars {
    //https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        char[] arr = s.toCharArray();
        int length = arr.length;
        int ans = 0;
        int index = 0;
        
        while(index<length){
            char c = arr[index];
            if(map.containsKey(c)){
                index = map.get(c);
                if(map.size() > ans){
                    ans = map.size();
                }
                map.clear();
            }else{
                map.put(c, index);
            }
            index++;
        }
        if(map.size() > ans){
            ans = map.size();
        }
        return ans;
    }
}
