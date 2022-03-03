class LFUCache {
    //https://leetcode.com/problems/lfu-cache/
    class Node{
        int key;
        int val;
        int freq;
        Node prev;
        Node next;
    }
    
    class DLL{
        Node head;
        Node tail;
        int size;
        DLL(){
            size = 0;
            head = new Node();
            tail = new Node();
            head.next = tail;
            tail.prev = head;
        }
        private void insert(Node node){
            node.prev = head;
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            size++;
        }
    
        private void remove(Node node){
            Node p = node.prev;
            Node n = node.next;

            p.next = n;
            n.prev = p;
            size--;
        }

        private void moveToHead(Node node){
            remove(node);
            insert(node);
        }

        private Node popTail(){
            Node last = tail.prev;
            remove(last);
            return last;
        }
        
        private int getSize(){
            return size;
        }
    }
    
    
    HashMap<Integer, Node> cache = new HashMap<>();
    HashMap<Integer, DLL> freqLists = new HashMap<>();
    int minFreq;
    int capacity;
    
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        minFreq = 0;
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if(node == null){
            return -1;
        }else{
            int curFreq = node.freq;
            DLL dll = freqLists.get(curFreq);
            dll.remove(node);
           
            if(dll.getSize() == 0 && curFreq == minFreq) minFreq++;
            
            int newFreq = curFreq + 1;
            dll = freqLists.get(newFreq);
            if(dll == null){
                dll = new DLL();
                dll.insert(node);
            }else{
                node.freq = newFreq;
                dll.insert(node);
            }
            return node.val;
        }
    }
    
    public void put(int key, int value) {
        
        Node n = new Node();
        n.key = key;
        n.val = value;
        if(cache.containsKey(key)) {
            n = cache.get(key);
            n.val = value;
        } else {
            if(this.capacity == 0) return;
            if(cache.size() == this.capacity && minFreq != 0) {
                int mF = minFreq;
                int lastKey = freqLists.get(mF).popTail().key;
                cache.remove(lastKey);
            }  
        }
        
        cache.put(key, n);
        DLL curList = new DLL();
        if(freqLists.containsKey(n.freq)) {
            curList = freqLists.get(n.freq);
            curList.remove(n);
        }
        if(curList.getSize() == 0 && n.freq == minFreq) minFreq++;
        n.freq = n.freq+1;
        freqLists.computeIfAbsent(n.freq, f->new DLL()).insert(n);
        // reset minFreq if this node is brand new
        minFreq = Math.min(n.freq, minFreq);
        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
