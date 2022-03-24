class FrequencySort {
    //https://leetcode.com/problems/sort-characters-by-frequency/submissions/
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++){
            char c = arr[i];
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        List<Character> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys, (a,b) -> map.get(b) - map.get(a));
        
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<keys.size();i++){
            int copies = map.get(keys.get(i));
            for(int j=0;j<copies;j++){
                ans.append(keys.get(i));    
            }
        }
        
        return ans.toString();
    }
}
