class AutocompleteSystem {
    //https://leetcode.com/problems/design-search-autocomplete-system/
    Trie trie; // Trie DS to look-up for prefix searches
    Map<String, Integer> freqMap; // Map to maintain the frequencies of the sentences
    StringBuilder currStr; // Current input string being searched
	
	// Load the freqMap & Trie with sentences & their frequencies
    public AutocompleteSystem(String[] sentences, int[] times) {
        trie = new Trie();
        freqMap = new HashMap<>();
        currStr = new StringBuilder();
        
        for(int i=0 ; i < sentences.length; i++){
            freqMap.put(sentences[i], times[i]);
            trie.insert(sentences[i]);
        }
    }
    
	// Update the currrent prefix string with the current input character & return the result as expected
    public List<String> input(char c) {
	    
		// If end of current input sentence then add it to our freqMap & Trie and reset the current prefix string
        if(c == '#'){
            freqMap.put(currStr.toString(), freqMap.getOrDefault(currStr.toString(), 0) + 1);
            trie.insert(currStr.toString());
            currStr = new StringBuilder();
            return new ArrayList<>();
        }
		
		// If input char is NOT '#' then we append it to the current prefix string & do a prefix search on Trie with the updated prefix string
        currStr.append(c);
        List<String> strs = trie.search(currStr.toString());
		
		// The result returned from Trie search is added to a priority queue which sorts the data as expected
        PriorityQueue<Map.Entry<String, Integer>> pq = 
            new PriorityQueue<>((a,b) -> b.getValue() == a.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
        for(String str : strs)
            pq.add(Map.entry(str, freqMap.get(str)));
        
		// Finally we filter the result as expected and return it
        List<String> result = new ArrayList<>();
        for(int i=0; i < 3; i++){
            if(pq.size() > 0)
                result.add(pq.poll().getKey());
        }
        return result;
    }
}

class Trie{
    
    TrieNode root;
    Trie(){
        this.root = new TrieNode(false);
    }
    
    public void insert(String word){
        TrieNode curr = root;
        for(char c : word.toCharArray()){
            if(!curr.nodes.containsKey(c))
                curr.nodes.put(c, new TrieNode(false));
            curr = curr.nodes.get(c);
        }
        curr.isEnd = true;
    }
    
    public List<String> search(String prefix){
        TrieNode curr = root;
        
        for(char c : prefix.toCharArray()){
            if(!curr.nodes.containsKey(c))
                return new ArrayList<>();
            curr = curr.nodes.get(c);
        }

		// We perform a DFS on the TrieNode on which the prefix String's last character ends
		// All sentences formed from the DFS are potential results
        List<String> result = new ArrayList<>(); 
        dfs(curr, result, new StringBuilder(prefix.toString()));
        return result;
    }
    
    void dfs(TrieNode curr, List<String> strs, StringBuilder prefix){
        if(curr.isEnd)
            strs.add(new String(prefix.toString()));
        
        for(char c : curr.nodes.keySet()){
            dfs(curr.nodes.get(c), strs, prefix.append(c));
            prefix.deleteCharAt(prefix.length() - 1);
        }
    }
}

class TrieNode {
    Map<Character, TrieNode> nodes = new HashMap<>();
    boolean isEnd;
    
    TrieNode(boolean isEnd){
        this.isEnd = isEnd;
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
