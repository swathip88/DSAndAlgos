class LRUCache {
    //https://leetcode.com/problems/lru-cache/submissions/
    class Node{
        int key;
        int val;
        Node prev;
        Node next;
    }
    
    Node head;
    Node tail;
    int capacity;
    HashMap<Integer, Node> cache = new HashMap<>();
    
    private void insert(Node node){
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }
    
    private void remove(Node node){
        Node p = node.prev;
        Node n = node.next;
        
        p.next = n;
        n.prev = p;
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
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node n = cache.get(key);
        if(n != null){
            moveToHead(n);    
        }else{
            return -1;
        }
        return n.val;
    }
    
    public void put(int key, int value) {
        Node n = cache.get(key);
        if(n == null){
            Node node = new Node();
            node.val = value;
            node.key = key;
            cache.put(key, node);
            if(cache.size() > this.capacity){
                Node popped = popTail();
                cache.remove(popped.key);
                insert(node);
            }else{
                insert(node);
            }
        }else{
            n.val = value;
            moveToHead(n);
        }
    }
}




/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
