class WordDictionary {
    //https://leetcode.com/problems/design-add-and-search-words-data-structure/submissions/
    Node root = new Node('a'); // dummy value

    public WordDictionary() {}
    
    public void addWord(String word) {
        Node node = root;
        for (int i=0; i<word.length(); i++) {
            char ch = word.charAt(i);
            if (!node.isChild(ch))
                node.addChild(ch);
            node = node.getChild(ch);
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {        
        return dfs(this.root, word, 0);
    }
    
    public boolean dfs(Node root, String word, int index) {
        if (root == null) {
            return false;
        }
        if (index == word.length()) { // if reached end of word
            return root.isEnd;
        }
        
        char ch = word.charAt(index);
        if (ch == '.') {
            for (Node child : root.childs) {
                boolean found = dfs(child, word, index + 1);
                if (found) {
                    return true;
                }
            }
            return false;
        }
        
        if (!root.isChild(ch)) {
            return false;
        }
        
        return dfs(root.getChild(ch), word, index + 1);
    }
}

class Node {
    char value;
    boolean isEnd;
    Node[] childs;
    
    Node(char value) {
        this.value = value;
        this.isEnd = false;
        this.childs = new Node[26];
    }
    
    Node getChild(char ch) {
        return this.childs[ch - 'a'];
    }
    
    boolean isChild(char ch) {
        return getChild(ch) != null;
    }
    
    void addChild(char ch) {
        this.childs[ch - 'a'] = new Node(ch);
    }
}
