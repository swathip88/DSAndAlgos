class Trie {
    //https://leetcode.com/problems/implement-trie-prefix-tree/submissions/
    TrieNode root;
    public Trie() {
        root = new TrieNode();
    }
    
    public void insert(String word) {
        char[] arr = word.toCharArray();
        TrieNode temp = root;
        for(int i=0;i<arr.length;i++){
            char c = arr[i];
            
            if(temp.containsKey(c)){
                temp = temp.get(c);
            }else{
                temp.insertCharacter(c, new TrieNode());
                temp = temp.get(c);
            }
        }
        temp.setIsEndNode(true);
        
    }
    
    public boolean search(String word) {
        char[] arr = word.toCharArray();
        TrieNode temp = root;
        
        for(int i=0;i<arr.length;i++){
            if(temp.containsKey(arr[i])){
                temp = temp.get(arr[i]);
            }else{
                return false;
            }
        }
        if(temp.isEndNode)
            return true;
        else 
            return false;
    }
    
    public boolean startsWith(String prefix) {
        char[] arr = prefix.toCharArray();
        TrieNode temp = root;
        
        for(int i=0;i<arr.length;i++){
            if(temp.containsKey(arr[i])){
                temp = temp.get(arr[i]);
            }else{
                return false;
            }
        }
        
        return true;
    }
    
    class TrieNode{
        private TrieNode[] children;
        private boolean isEndNode ;
        TrieNode(){
            children = new TrieNode[26];
        }
        
        public void setIsEndNode(boolean isEndNode){
            this.isEndNode = isEndNode;
        }
        
        public boolean getIsEndNode(){
            return this.isEndNode;
        }
        
        public void insertCharacter(char c, TrieNode child){
            children[c - 'a'] = child;
        }
        
        public boolean containsKey(char c)
        {
            return children[c-'a'] != null;    
        } 
        
        public TrieNode get(char c){
            return children[c - 'a'];
        }
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
