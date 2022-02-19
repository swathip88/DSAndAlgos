class LongestSubStringKDistinctCharacters {
    //https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/submissions/
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        
        char[] arr = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        int i=0;
        int maxLength = 0;
        int startIndex = i;
        if(k==0){
            return 0;
        }
        while(i< arr.length){
            char c = arr[i];
            map.put(c, i);
            i++;
            if(map.size() == k +1){
                List<Integer> l = map.values().stream().sorted().collect(Collectors.toList());
                
                startIndex = l.get(0) + 1;
                map.remove(arr[l.get(0)]);
            }
            maxLength = Math.max(maxLength, i-startIndex);
        }
        return maxLength;
    }
}
