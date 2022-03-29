class CountCharacters {
    //https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/submissions/
    public int countCharacters(String[] words, String chars) {
        Map<Character,Integer>map = new HashMap<>();
        map = charFrequency(chars);
        int len=0;
        for(String s : words){
            Map<Character,Integer>temp = charFrequency(s);
            int count=0;
            for(Map.Entry e:temp.entrySet()){
                if(map.containsKey(e.getKey())
                  && (map.get(e.getKey())>=(Integer)e.getValue())){
                        count+=(Integer)e.getValue();
                }
                    
            }
            if(count==s.length())
                len+=count;
        }
        return len;
    }
    public Map<Character,Integer>charFrequency(String s){
        Map<Character,Integer>map=new HashMap<>();
        for(char c : s.toCharArray())
            map.put(c,map.getOrDefault(c,0)+1);
        return map;
    }
}
