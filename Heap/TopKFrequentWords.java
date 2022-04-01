class TopKFrequentWords {
    //https://leetcode.com/problems/top-k-frequent-words/submissions/
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new TreeMap<>();
        
        for(String word: words){
            map.put(word, map.getOrDefault(word,0) + 1);
        }
        
        
        Comparator<String> comp = new Comparator<String>() {
            public int compare(String str1, String str2){
            int diff = map.get(str1) - map.get(str2);    
            if(diff == 0) return str2.compareTo(str1);// If they are equal count. We want to remove element high in alphabetical order(convert to max heap)
        return diff;  
      }  
    };
        
        Queue<String> heap = new PriorityQueue<>(
            comp);
        
        for(String word: map.keySet()){
            heap.add(word);
            if(heap.size() > k){
                heap.poll();
            }
        }
        
        List<String> ans = new ArrayList<>();
        while(!heap.isEmpty()){
            ans.add(0,heap.poll());
        }
        
        return ans;
    }
}
