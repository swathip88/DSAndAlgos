class FirstUniqueCharacter {
    //https://leetcode.com/problems/first-unique-character-in-a-string/submissions/
    public int firstUniqChar(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        
        for(int i=0;i<arr.length;i++){
            char c = arr[i];
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for(int i=0;i<arr.length;i++){
            if(map.get(arr[i]) == 1){
                return i;
            }
        }
        return -1;
    }
}
