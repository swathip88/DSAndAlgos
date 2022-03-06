class LadderLength {
    //https://leetcode.com/problems/word-ladder/submissions/
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)){
            return 0;
        }
        wordList.add(beginWord);
        HashMap<String, ArrayList<String>> adjList = buildAdjacentList(wordList);
        
        HashMap<String, Integer> distances = new HashMap<>();
        for(String word: wordList){
            distances.put(word, Integer.MAX_VALUE - 1);
        }
        distances.put(beginWord, 1);
        
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        
        while(!queue.isEmpty()){
            String w = queue.poll();
            List<String> adjWords = adjList.get(w);
            for(int i=0;i<adjWords.size();i++){
                if(distances.get(w) < distances.get(adjWords.get(i))){
                    distances.put(adjWords.get(i), distances.get(w) + 1);
                    queue.add(adjWords.get(i));
                }
            }
               
        }
        
        if(distances.get(endWord) < Integer.MAX_VALUE - 1){
            return distances.get(endWord);
        }else{
            return 0;
        }
    }
    
    
    private HashMap<String, ArrayList<String>> buildAdjacentList(List<String> wordList){
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for(String word: wordList) {
            ArrayList<String> adjacentWords = new ArrayList<>();
            
            for(String w: wordList){
                int diffs = noOfDifferences(word, w);
                if(diffs ==1){
                    adjacentWords.add(w);
                }
            }
            map.put(word, adjacentWords);
        }   
            
        return map;
    }
    
    private int noOfDifferences(String s, String t){
        int count = 0;
        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();
        
        for(int i=0;i<arr1.length;i++){
            if(arr1[i] != arr2[i]){
                count++;
            }
        }
        
        return count;
    }
}
