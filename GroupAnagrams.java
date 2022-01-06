class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //https://leetcode.com/problems/group-anagrams/submissions/
        Map<String, List<String>> map = new HashMap<>();
        
        for(int i=0;i<strs.length; i++){
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String sortedStr = new String(arr);
            if(map.containsKey(sortedStr)){
                List<String> existingList = map.get(sortedStr);
                List<String> newList = new ArrayList<>();
                newList.addAll(existingList);
                newList.add(strs[i]);
                map.put(sortedStr,newList);

                
            }else{
                map.put(sortedStr, Arrays.asList(strs[i]));
            }
        }
        List<List<String>> list = map.values().stream().collect(Collectors.toList());
        return list;
    }
}
